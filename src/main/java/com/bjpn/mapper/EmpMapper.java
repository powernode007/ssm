package com.bjpn.mapper;

import com.bjpn.bean.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    int deleteByPrimaryKey(Integer empNo);

    int insert(Emp record);

    boolean insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer empNo);

    boolean updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
    List<Emp> getAllEmp(@Param("startIndex")int startIndex, @Param("pageSize")int pageSize, @Param("likeName")String likeName);
    //总记录数查询
    int  getCount(String likeName);

}