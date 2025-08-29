package com.yep.web.service;

import java.util.List;

import com.yep.web.pojo.Dept;

public interface DeptService {

    /**
     * 获取所有部门
     * @return 部门列表
     */
    List<Dept> findAll();

    void delete(Integer id);

    void save(Dept entity);

    Dept getInfo(Integer id);

    void update(Dept entity);
}
