package com.bjpn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
    @RequestMapping("/toMain.action")
    public String toMain(){
        return "main/index";
    }
    @RequestMapping("/toBackIndex.action")
    public String toBackIndex(){
        return "main/backIndex";
    }
    @RequestMapping("/toDept.action")
    public String toDept(){
        return "dept/dept";
    }

}
