package com.yep.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yep.web.pojo.Violation;

@Mapper
public interface ViolationMapper {

    /**
     * 批量插入违纪信息
     */
    void insert(List<Violation> violationList);

	void deleteByStudentIds(List<Integer> ids);

}
