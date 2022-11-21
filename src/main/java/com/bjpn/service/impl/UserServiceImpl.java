package com.bjpn.service.impl;

import com.bjpn.bean.Emp;
import com.bjpn.bean.User;
import com.bjpn.mapper.UserMapper;
import com.bjpn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User loginUserService(String userCode, String userPwd) {
        return userMapper.loginUser(userCode, userPwd);
    }

    @Override
    public int addEmployeeService(Emp emp) {
        return userMapper.addEmployee(emp);

    }

    @Override
    public List<Emp> selectEmpService() {
        return userMapper.selectEmp();
    }
}
