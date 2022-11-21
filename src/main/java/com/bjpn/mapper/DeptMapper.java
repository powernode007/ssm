package com.bjpn.mapper;

import com.bjpn.bean.Dept;

import java.util.List;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer deptNo);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptNo);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    List<Dept> getAllDeptList();

}