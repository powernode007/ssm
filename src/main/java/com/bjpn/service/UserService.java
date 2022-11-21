package com.bjpn.service;

import com.bjpn.bean.Emp;
import com.bjpn.bean.User;

import java.util.List;

public interface UserService {
    //登录
    User  loginUserService(String userCode,String userPwd);
    //添加
    int addEmployeeService(Emp emp);
    //查询
    List<Emp> selectEmpService();
}
