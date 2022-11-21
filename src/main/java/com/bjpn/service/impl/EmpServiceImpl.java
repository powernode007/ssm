package com.bjpn.service.impl;

import com.bjpn.bean.Emp;
import com.bjpn.mapper.EmpMapper;
import com.bjpn.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class EmpServiceImpl implements EmpService{
    @Autowired
    EmpMapper empMapper;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Emp> findAllEmp(int startIndex, int pageSize, String likeName) {
        return empMapper.getAllEmp(startIndex, pageSize, likeName);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public boolean saveEmp(Emp emp) {
        return empMapper.insertSelective(emp);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int getCountService(String likeName) {
        return empMapper.getCount(likeName);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int deleteOneEmp(Integer empNo) {
        return empMapper.deleteByPrimaryKey(empNo);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Emp selectOneEmp(Integer empNo) {
        return empMapper.selectByPrimaryKey(empNo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public boolean updateOneEmp(Emp emp) {
        return empMapper.updateByPrimaryKeySelective(emp);
    }


}
