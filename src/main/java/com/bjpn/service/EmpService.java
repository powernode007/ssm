package com.bjpn.service;

import com.bjpn.bean.Emp;

import java.util.List;

public interface EmpService {
    //查看所有员工信息（分页，模糊查询）
    List<Emp> findAllEmp(int startIndex,int pageSize,String likeName);
    //添加员工
    boolean saveEmp(Emp emp);
    //总条数（模糊查询）
    int  getCountService(String likeName);
    //删除一条
    int deleteOneEmp(Integer empNo);
    //根据主键查询
    Emp selectOneEmp(Integer empNo);
    //修改
    boolean updateOneEmp(Emp emp);

}
