package com.bjpn.mapper;

import com.bjpn.bean.Emp;
import com.bjpn.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {
    //登录
    User loginUser(@Param("userCode")String UserCode,@Param("userPwd")String userPwd);
    //添加
    int addEmployee(Emp emp);
    //查询
    List<Emp> selectEmp();

}
