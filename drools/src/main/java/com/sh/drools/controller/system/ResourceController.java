package com.sh.drools.controller.system;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sh.drools.common.AjaxResult;
import com.sh.drools.common.DataGrid;
import com.sh.drools.dal.model.Resource;
import com.sh.drools.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 资源管理控制器
 *
 * @author gson
 */
@Controller
@RequestMapping("/system/resource")
@Transactional(readOnly = true)
public class ResourceController {
    Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    ResourceService resourceService;

    @RequestMapping
    public void index() {
    }

    @RequestMapping("/list")
    @ResponseBody
    public DataGrid<Resource> list() {
        return new DataGrid<>(resourceService.findAll());
    }

    @RequestMapping("/parent/tree")
    @ResponseBody
    public Iterable<Resource> parentTree() {
        return resourceService.getResourceTree();
    }

    @RequestMapping("form")
    public void form(Integer id, Model model) {
        if (id != null) {
            ObjectMapper mapper = new ObjectMapper();
            Resource resource = resourceService.findOne(id);
            try {
                model.addAttribute("resource", mapper.writeValueAsString(resource));
            } catch (JsonProcessingException e) {
                logger.error("json转换错误", e);
            }
            if (resource.getParent() != null) {
                model.addAttribute("parentId", resource.getParent().getId());
            }
        }
    }

    @RequestMapping({"/save", "/update"})
    @Transactional
    @ResponseBody
    public Object save(Resource resource, BindingResult br) {
        if (br.hasErrors()) {
            logger.error("对象校验失败：" + br.getAllErrors());
            return new AjaxResult(false).setData(br.getAllErrors());
        } else {
            return resourceService.save(resource);
        }
    }

    @RequestMapping("/delete")
    @Transactional
    @ResponseBody
    public AjaxResult delete(Integer id) {
        try {
            resourceService.delete(id);
        } catch (Exception e) {
            return new AjaxResult().setMessage(e.getMessage());
        }
        return new AjaxResult();
    }
}