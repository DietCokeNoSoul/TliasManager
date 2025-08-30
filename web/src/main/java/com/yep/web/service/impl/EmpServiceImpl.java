package com.yep.web.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yep.web.mapper.EmpExprMapper;
import com.yep.web.mapper.EmpMapper;
import com.yep.web.pojo.Emp;
import com.yep.web.pojo.EmpExpr;
import com.yep.web.pojo.EmpQueryParam;
import com.yep.web.pojo.PageResult;
import com.yep.web.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    /**
     * 查询员工列表
     * @param empQueryParam 查询参数
     * @return 分页结果
     */
    public PageResult<Emp> list(EmpQueryParam empQueryParam) {
        // 设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        // 查询列表
        List<Emp> empList = empMapper.list(empQueryParam);
        // 转换为分页对象
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    /**
     * 创建员工
     * @param emp 员工信息
     */
    @Transactional(rollbackFor = Exception.class)
    public void createEmp(Emp emp) {
        empMapper.insert(emp);
        List<EmpExpr> empExprList = emp.getEmpExprList();
        if (empExprList != null && empExprList.size() > 0) {
            empExprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
            empExprMapper.insert(empExprList);
        }
    }

    /**
     * 删除员工
     * @param ids 员工ID列表
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteEmp(List<Integer> ids) {
        // 先删除员工经历，因为员工id为其外键
        empExprMapper.deleteByEmpId(ids);
        empMapper.delete(ids);
    }

    /**
     * 根据ID获取员工信息
     * @param id 员工ID
     * @return 员工信息
     */
    public Emp getEmpById(Integer id) {
        Emp emp = empMapper.getById(id);
        return emp;
    }

    /**
     * 更新员工信息
     * @param emp
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateEmp(Emp emp) {
        // 修改员工信息
        empMapper.update(emp);
        // 修改工作经历
        empExprMapper.deleteByEmpId(Arrays.asList(emp.getId()));
        List<EmpExpr> empExprList = emp.getEmpExprList();
        if (empExprList != null && empExprList.size() > 0) {
            empExprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
            empExprMapper.insert(empExprList);
        }
    }

}
