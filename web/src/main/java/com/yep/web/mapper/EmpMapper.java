package com.yep.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import com.yep.web.pojo.Emp;
import com.yep.web.pojo.EmpQueryParam;

/**
 * 员工数据访问层
 */
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

    /**
     * 删除员工
     * @param ids 员工ID列表
     */
    public void delete(List<Integer> ids);

    /**
     * 根据ID获取员工信息
     * @param id 员工ID
     * @return 员工信息
     */
    public Emp getById(Integer id);

    /**
     * 更新员工信息
     * @param emp 员工信息
     */
    public void update(Emp emp);

    /**
     * 统计员工职位分布
     * @return 职位分布数据
     */

    List<Map<String, Object>> countEmpJobData();

    /**
     * 统计员工性别分布
     * @return 性别分布数据
     */
    List<Map<String, Object>> countEmpGenderData();
}
