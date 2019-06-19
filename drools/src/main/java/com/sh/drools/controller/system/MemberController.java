package com.sh.drools.controller.system;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sh.drools.common.AjaxResult;
import com.sh.drools.common.DataGrid;
import com.sh.drools.common.PageQueryRequest;
import com.sh.drools.dal.model.Member;
import com.sh.drools.dal.model.Role;
import com.sh.drools.service.MemberService;
import com.sh.drools.service.RoleService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理控制器
 *
 * @author gson
 */
@Controller
@RequestMapping("/system/member")
@Transactional(readOnly = true)
public class MemberController {
    private static Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    MemberService memberService;
    @Autowired
    RoleService roleService;

    /**
     * 超级管理员id
     */
    @Value("${crm.system.super-user-id}")
    Long superUserId;

    @RequestMapping
    public void index() {

    }

    @RequestMapping("/list")
    @ResponseBody
    public DataGrid<Member> list(int page, int rows, String userName, String realName, String telephone) {
        PageQueryRequest<Member> request = new PageQueryRequest<>();
        request.setPageNumber(page);
        request.setPageSize(rows);
        Member member = new Member();
        member.setUserName(userName);
        member.setRealName(realName);
        member.setTelephone(telephone);
        request.setT(member);
        return new DataGrid<Member>(memberService.pageQuery(request).getList());
    }

    @RequestMapping("/form")
    public void form(int id, Model model) {
        if (id != 0) {
            ObjectMapper mapper = new ObjectMapper();
            Member member = memberService.findOne(id);
            try {
                model.addAttribute("member", mapper.writeValueAsString(member));
            } catch (JsonProcessingException e) {
                logger.error("json转换错误", e);
            }
        }
    }

    @RequestMapping("/check")
    @ResponseBody
    public boolean check(String userName) {
        return memberService.countByUserName(userName) == 0;
    }

    @RequestMapping("/roles")
    @ResponseBody
    public List<Role> roles() {
        return roleService.findByStatus(true);
    }

    @RequestMapping({"/save", "/update"})
    @Transactional
    @ResponseBody
    public AjaxResult save(Member member, Integer[] roles, BindingResult br) {
        if (br.hasErrors()) {
            logger.error("对象校验失败：" + br.getAllErrors());
            return new AjaxResult(false).setData(br.getAllErrors());
        } else {
            boolean result = false;
            try{
                if (member.getId() != null) {
                    // 不在这里更新角色和密码
                    Member orig = memberService.findOne(member.getId());
                    // 理论上这里一定是要找得到对象的
                    if (orig != null) {
                        member.setPassword(orig.getPassword());
                    }
                } else {
                    // 默认密码
                    member.setPassword(DigestUtils.sha256Hex("0000"));
                }
    
                //处理角色的关联
                if (roles != null && roles.length > 1) {
                    List<Role> rolesList = new ArrayList<>();
                    for (Integer rid : roles) {
                        if (rid != null) {
                            rolesList.add(roleService.findOne(rid));
                        }
                    }
                    member.setRoles(rolesList);
                }
    
                memberService.save(member);
                result = true;
            }catch(Exception e){
                logger.error("账户{}更新异常",member.getRealName() , e);
            }

            return new AjaxResult(result,"账户"+member.getRealName()+(result ? "操作成功！":"操作失败！"));
        }
    }

    /**
     * 重置密码
     *
     * @param id
     * @return
     */
    @RequestMapping("/password/reset")
    @Transactional
    @ResponseBody
    public AjaxResult resetPassword(int id) {
        Member member = memberService.findOne(id);
        member.setPassword(DigestUtils.sha256Hex("0000"));
        memberService.save(member);
        return new AjaxResult();
    }

    @RequestMapping("/delete")
    @Transactional
    @ResponseBody
    public AjaxResult delete(int id) {
        try {
            if (!superUserId.equals(id)) {
                memberService.delete(id);
            } else {
                return new AjaxResult(false, "管理员不能删除！");
            }
        } catch (Exception e) {
            return new AjaxResult(false).setMessage(e.getMessage());
        }
        return new AjaxResult();
    }
}
