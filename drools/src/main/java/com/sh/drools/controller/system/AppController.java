package com.sh.drools.controller.system;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sh.drools.common.*;
import com.sh.drools.dal.model.Member;
import com.sh.drools.dal.model.Resource;
import com.sh.drools.dal.model.Role;
import com.sh.drools.service.AttachmentService;
import com.sh.drools.service.MemberService;
import com.sh.drools.service.ResourceService;
import com.sh.drools.service.RoleService;
import org.apache.commons.codec.digest.DigestUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

/**
 * 系统的入口控制器，入口控制器里面的请求，理论上都受权限控制
 */
@Controller
public class AppController {
    Logger logger = LoggerFactory.getLogger(AppController.class);

    @Autowired
    MemberService memberService;
    @Autowired
    RoleService roleService;
    @Autowired
    ResourceService resourceService;
    @Autowired
    AttachmentService attachmentService;

    /**
     * 超级管理员id
     */
    @Value("${crm.system.super-user-id}")
    Integer superUserId;

    @RequestMapping("/")
    public String index(HttpSession session) {
        if(session.getAttribute(Constants.SESSION_MEMBER_KEY) == null){
            return "redirect:/login";
        }
        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpSession session) {
        if (session.getAttribute(Constants.SESSION_MEMBER_KEY) != null) {
            return "redirect:/";
        }
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    /**
     * 权限resource的js资源
     *
     * @param session
     * @return
     */
    @RequestMapping("/resource")
    public String login(HttpSession session, Model model) {
        ObjectMapper mapper = new ObjectMapper();
        Object resourceKey = session.getAttribute("resourceKey");
        try {
            model.addAttribute("resourceKey", mapper.writeValueAsString(resourceKey));
        } catch (JsonProcessingException e) {
            logger.error("json转换错误", e);
        }
        return "resource";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLoin(String userName, String password, RedirectAttributes rAttributes, HttpSession session) {
        // 参数校验
        if (isEmpty(userName) || isEmpty(password)) {
            rAttributes.addFlashAttribute("error", "参数错误！");
            return "redirect:/login";
        }

        Member member = memberService.findByUserName(userName);

        // 校验密码
        if (member == null || member.getStatus() != 1) {
            rAttributes.addFlashAttribute("error", "用户不存在或已被禁用！");
            return "redirect:/login";
        } else if (!member.getPassword().equals(DigestUtils.sha256Hex(password))) {
            rAttributes.addFlashAttribute("error", "用户名或密码错误！");
            return "redirect:/login";
        }

        final List<Resource> allResources;

        // 获取用户可用菜单,所有有权限的请求，所有资源key

        List<Role> roles = member.getRoles();

        List<Resource> menus = new ArrayList<Resource>();
        Set<String> urls = new HashSet<>();
        Set<String> resourceKey = new HashSet<>();

        if (superUserId == member.getId()) {
            // 超级管理员，直接获取所有权限资源
            allResources = resourceService.findByStatus(true);
        } else {
            allResources = new ArrayList<>();
            // forEach 1.8jdk才支持
            roles.forEach(t -> allResources.addAll(t.getResource()));
            // 按weight都倒序排序
//            ListSortUtils.sort(allResources, false, "weight");
        }

        for (Resource t : allResources) {
            // 可用菜单
            if (t.getResType().equals(ResourceType.MENU)) {
                menus.add(t);
            }

            //所有请求资源
            if (isNotEmpty(t.getMenuUrl())) {
                urls.add(t.getMenuUrl());
            }

            if (isNotEmpty(t.getFunUrls())) {
                String[] funUrls = t.getFunUrls().split(",");
                for (String url : funUrls) {
                    if (isNotEmpty(url)) {
                        urls.add(url);
                    }
                }
            }

            // 资源key
            resourceKey.add(t.getResKey());
        }

        // 将用户可用菜单和权限存入session
        session.setAttribute("menus", menus);
        session.setAttribute("urls", urls);
        session.setAttribute("resourceKey", resourceKey);
        session.setAttribute(Constants.SESSION_MEMBER_KEY, member);
        // 是否是管理员
        session.setAttribute("isSuper", superUserId == member.getId());
        return "redirect:/";
    }

    /**
     * 注册
     *
     * @return
     */
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String toReg() {
        return "reg";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    @Transactional
    public String doReg(String realName, String userName, String password, String code, @SessionAttribute(Constants.SESSION_VERIFY_CODE_KEY) String verifyCode, RedirectAttributes attributes) {
        if (isEmpty(code)) {
            attributes.addFlashAttribute("error", "验证码不能为空！");
        } else if (!code.equalsIgnoreCase(verifyCode)) {
            attributes.addFlashAttribute("error", "验证码错误！");
        } else if (isEmpty(realName)) {
            attributes.addFlashAttribute("error", "姓名不能为空！");
        } else if (isEmpty(userName)) {
            attributes.addFlashAttribute("error", "账号不能为空！");
        } else if (isEmpty(password)) {
            attributes.addFlashAttribute("error", "密码不能为空！");
        } else if (password.length() < 6) {
            attributes.addFlashAttribute("error", "密码不能小于6位！");
        } else if (memberService.findByUserName(userName) != null) {
            attributes.addFlashAttribute("error", "此账号已存在！");
        }

        if (attributes.getFlashAttributes().size() > 0) {
            return "redirect:/reg";
        } else {
            Member member = new Member();
            member.setRealName(realName);
            member.setGender(Gender.BOY.getCode());
            member.setUserName(userName);
            member.setPassword(DigestUtils.sha256Hex(password));
            member.setTelephone(userName);
            member.setEmail(userName + "@qq.com");
            member.setHiredate(new Date());
            member.setStatus(1);
            List<Role> roles = new ArrayList<>();
            roles.add(roleService.findOne(3));
            member.setRoles(roles);
            memberService.save(member);
        }
        return "redirect:/login";
    }

    /**
     * 校验码
     *
     * @param response
     * @param session
     */
    @RequestMapping(value = "/verify/code", method = RequestMethod.GET)
    public void verifyCode(HttpServletResponse response, HttpSession session) {
        try {
            String code = VerifyCodeUtils.outputVerifyImage(150, 50, response.getOutputStream(), 4);
            session.setAttribute(Constants.SESSION_VERIFY_CODE_KEY, code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/desktop")
    public String desktop() {
        return "desktop";
    }

    /**
     * 请求权限被拒绝的提醒页面
     *
     * @return
     */
    @RequestMapping("/reject")
    public String reject() {
        return "reject";
    }

    /**
     * 修改密码
     */
    @RequestMapping("/change/password")
    public String changePassword() {
        return "password";
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "/change/password", method = RequestMethod.POST)
    @Transactional
    @ResponseBody
    public AjaxResult doChangePassword(@SessionAttribute(name = "s_member") Member member, String oldPassword, String newPassword1, String newPassword2) {
        if (isEmpty(oldPassword) || isEmpty(newPassword1) || isEmpty(newPassword2)) {
            return new AjaxResult(false).setMessage("参数错误！");
        }

        if (!member.getPassword().equals(DigestUtils.sha256Hex(oldPassword))) {
            return new AjaxResult(false).setMessage("原密码错误！");
        }

        if (!DigestUtils.sha256Hex(newPassword1).equals(DigestUtils.sha256Hex(newPassword2))) {
            return new AjaxResult(false).setMessage("新密码，两次不匹配！");
        }

        Member m = memberService.findOne(member.getId());
        m.setPassword(DigestUtils.sha256Hex(newPassword1));
        memberService.save(m);

        return new AjaxResult();
    }

    /**
     * 修改用户资料
     */
    @RequestMapping("/change/info")
    public String changeInfo() {
        return "info";
    }

    /**
     * 修改用户资料
     */
    @RequestMapping(value = "/change/info", method = RequestMethod.POST)
    @Transactional
    @ResponseBody
    public AjaxResult doChangeInfo(@SessionAttribute("s_member") Member smember, Member member, HttpSession session) {

        if (isEmpty(member.getRealName()) || isEmpty(member.getTelephone()) || isEmpty(member.getEmail()) || member.getGender() == null) {
            return new AjaxResult(false).setMessage("参数错误！");
        }

        smember.setRealName(member.getRealName());
        smember.setGender(member.getGender());
        smember.setTelephone(member.getTelephone());
        smember.setEmail(member.getEmail());
        smember.setAvatar(member.getAvatar());
        memberService.save(smember);
        //清理工作
        attachmentService.clearAvatar(smember);
        session.setAttribute("s_member", smember);
        return new AjaxResult();
    }
}
