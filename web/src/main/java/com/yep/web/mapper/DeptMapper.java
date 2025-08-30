package com.yep.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yep.web.pojo.Dept;

/**
 * 部门数据访问层
 */
@Mapper
public interface DeptMapper {
    /**
     * 获取所有部门
     * @return 部门列表
     */
    List<Dept> findAll();

    /**
     * 删除部门
     * @param id 部门ID
     */
    void delete(Integer id);

    /**
     * 创建部门
     * @param entity 部门实体
     */
    void insert(Dept entity);

    /**
     * 根据ID获取部门
     * @param id 部门ID
     * @return 部门实体
     */
    Dept findById(Integer id);

    /**
     * 更新部门
     * @param dept 部门实体
     */
    void update(Dept dept);
}
