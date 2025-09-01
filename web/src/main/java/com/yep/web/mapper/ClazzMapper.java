package com.yep.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yep.web.pojo.Clazz;

/*
 * 班级数据访问层
 */
@Mapper
public interface ClazzMapper {

    /**
     * 查询所有班级
     */
    List<Clazz> selectAll();

    /**
     * 删除班级
     * @param id 班级ID
     */
    void delete(Integer id);

    /**
     * 插入班级
     * @param clazz 班级对象
     */
    void insert(Clazz clazz);

    /**
     * 根据ID查询班级
     * @param id 班级ID
     * @return 班级对象
     */
    Clazz selectById(Integer id);

    /**
     * 更新班级
     * @param clazz 班级对象
     */
    void update(Clazz clazz);
}
