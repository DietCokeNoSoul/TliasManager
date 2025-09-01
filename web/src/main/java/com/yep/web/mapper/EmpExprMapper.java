package com.yep.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yep.web.pojo.EmpExpr;

/**
 * 员工经历数据访问层
 */
@Mapper
public interface EmpExprMapper {

    /**
     * 批量插入员工经历
     * @param empExprList 员工经历列表
     */
    void insert(List<EmpExpr> empExprList);

    /**
     * 根据员工ID删除经历
     * @param empIds 员工ID列表
     */
    void deleteByEmpId(List<Integer> empIds);
}
