package com.sh.drools.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: liyong
 * @Date:2019/1/30 14:13
 * @Desc: 后台模板控制类
 */
@RequestMapping("/model")
@Controller
public class ModelController {
    @RequestMapping("/add")
    public String add(){
        return "/model/add";
    }
    @RequestMapping("/query")
    public String query(){
        return "/model/query";
    }

    @RequestMapping("/queryIndex")
    public String queryIndex(){
        return "/model/queryIndex";
    }
    @RequestMapping("/tab1")
    public String tab1(){
        return "/model/tab1";
    }
    @RequestMapping("/tab2")
    public String tab2(){
        return "/model/tab2";
    }
}
