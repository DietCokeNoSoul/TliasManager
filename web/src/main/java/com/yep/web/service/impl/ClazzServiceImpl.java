package com.yep.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yep.web.mapper.ClazzMapper;
import com.yep.web.pojo.Clazz;
import com.yep.web.service.ClazzService;

/*
 * 班级服务实现
 */
@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    /**
     * 查询所有班级
     */
    @Override
    public List<Clazz> findAll() {
        return clazzMapper.selectAll();
    }

    /**
     * 删除班级
     */
    @Override
    public void delete(Integer id) {
        clazzMapper.delete(id);
    }

    /**
     * 保存班级
     */
    @Override
    public void save(Clazz clazz) {
        clazzMapper.insert(clazz);
    }

    /**
     * 获取班级信息
     */
    @Override
    public Clazz getInfo(Integer id) {
        return clazzMapper.selectById(id);
    }

    /**
     * 更新班级
     */
    @Override
    public void update(Clazz clazz) {
        clazzMapper.update(clazz);
    }
}
