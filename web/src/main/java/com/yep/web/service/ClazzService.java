package com.yep.web.service;

import java.util.List;

import com.yep.web.pojo.Clazz;

/*
 * 班级服务
 */
public interface ClazzService {

    List<Clazz> findAll();

    void delete(Integer id);

    void save(Clazz clazz);

    Clazz getInfo(Integer id);

    void update(Clazz clazz);

}
