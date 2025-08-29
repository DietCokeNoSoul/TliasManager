package com.yep.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.yep.web.pojo.Emp;
import com.yep.web.pojo.EmpQueryParam;

@Mapper
public interface EmpMapper {

    /**
     * 查询员工列表
     * @return
     * 员工列表
     */
    public List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 插入员工
     * @param emp 员工信息
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(Emp emp);

    public void delete(List<Integer> ids);
}
