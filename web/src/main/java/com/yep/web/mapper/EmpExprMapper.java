package com.yep.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yep.web.pojo.EmpExpr;

@Mapper
public interface EmpExprMapper {

    /**
     * 批量插入员工经历
     * @param empExprList 员工经历列表
     */
    public void insert(List<EmpExpr> empExprList);

    /**
     * 根据员工ID删除经历
     * @param empIds 员工ID列表
     */
    public void deleteByEmpId(List<Integer> empIds);
}
