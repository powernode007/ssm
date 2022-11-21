package com.bjpn.service.impl;

import com.bjpn.bean.Dept;
import com.bjpn.mapper.DeptMapper;
import com.bjpn.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;
    @Override
    public List<Dept> findAllDeptService() {
        return deptMapper.getAllDeptList();
    }
}
