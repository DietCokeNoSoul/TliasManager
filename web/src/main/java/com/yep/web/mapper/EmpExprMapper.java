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

    public void deleteByEmpId(List<Integer> empIds);
}
