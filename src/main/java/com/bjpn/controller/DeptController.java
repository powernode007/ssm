package com.bjpn.controller;

import com.bjpn.bean.Dept;
import com.bjpn.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    DeptService deptService;
    @RequestMapping("/findAllDept.action")
    @ResponseBody
    public List<Dept> findAllDept() {
        List<Dept> deptList = deptService.findAllDeptService();
        return deptList;//为了给前端异步添加下拉菜单做准备
    }
}
