package com.yep.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yep.web.mapper.DeptMapper;
import com.yep.web.pojo.Dept;
import com.yep.web.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void delete(Integer id) {
        deptMapper.delete(id);
    }

    @Override
    public void save(Dept entity) {
        deptMapper.insert(entity);
    }

    @Override
    public Dept getInfo(Integer id) {
        return deptMapper.findById(id);
    }

    @Override
    public void update(Dept entity) {
        Dept dept = this.getInfo(entity.getId());
        if (dept != null) {
            dept.setName(entity.getName());
            deptMapper.update(dept);
        }
    }

}
