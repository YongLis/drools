package com.sh.drools.controller.system;

import com.sh.drools.common.AjaxResult;
import com.sh.drools.common.DataGrid;
import com.sh.drools.dal.model.Resource;
import com.sh.drools.dal.model.Role;
import com.sh.drools.service.ResourceService;
import com.sh.drools.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * 角色管理控制器
 *
 * @author gson
 */
@Controller
@RequestMapping("/system/role")
@Transactional(readOnly = true)
public class RoleController {

    Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    RoleService roleService;

    @Autowired
    ResourceService resourceService;

    @RequestMapping
    public void index() {
    }

    @RequestMapping("/list")
    @ResponseBody
    public DataGrid<Role> list() {
        return new DataGrid<>(roleService.findAll());
    }

    @RequestMapping({"/save", "/update"})
    @Transactional
    @ResponseBody
    public Object save(Role role, BindingResult br) {
        if (br.hasErrors()) {
            logger.error("对象校验失败：" + br.getAllErrors());
            return new AjaxResult(false).setData(br.getAllErrors());
        } else {
            role.setResource(null);
            return roleService.save(role);
        }
    }

    @RequestMapping("/delete")
    @Transactional
    @ResponseBody
    public AjaxResult delete(int id) {
        try {
            roleService.delete(id);
        } catch (Exception e) {
            return new AjaxResult().setMessage(e.getMessage());
        }
        return new AjaxResult();
    }

    @RequestMapping("/resource/tree")
    @ResponseBody
    public Iterable<Resource> resourceTree() {
        return resourceService.getResourceTree(true);
    }

    /**
     * 角色关联资源
     *
     * @param roleId
     * @param resourceId
     * @return
     */
    @RequestMapping("/resource/save")
    @Transactional
    @ResponseBody
    public AjaxResult resourceSave(Integer roleId, Integer[] resourceId) {
        Role role = roleService.findOne(roleId);
        if (role != null && resourceId != null && resourceId.length > 0) {
            try {
                role.setResource(new ArrayList<>());
                for (Integer rid : resourceId) {
                    if (rid != null) {
                        // 将资源关联到角色
                        role.getResource().add(resourceService.findOne(rid));
                    }
                }
                roleService.save(role);
                return new AjaxResult();
            } catch (Exception e) {
                logger.error("角色资源关联错误", e);
            }
        }
        return new AjaxResult(false, "关联失败！");
    }
}
