package com.yep.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yep.web.pojo.Emp;
import com.yep.web.pojo.EmpQueryParam;
import com.yep.web.pojo.PageResult;
import com.yep.web.pojo.Result;
import com.yep.web.service.EmpService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 获取员工列表
     * @param empQueryParam 查询参数
     */
    @GetMapping("/list")
    public Result list(EmpQueryParam empQueryParam) {
        log.info("获取员工数据，查询参数：{}", empQueryParam);
        PageResult<Emp> pageResult = empService.list(empQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 创建员工，同时创建员工经历
     * @param entity 员工信息
     */
    @PostMapping
    public Result createEmp(@RequestBody Emp entity) {
        log.info("创建员工，参数：{}", entity);
        empService.createEmp(entity);
        return Result.success();
    }

    /**
     * 删除员工,批量，同时删除员工员工经历
     * @param ids
     * @return
     */
    @DeleteMapping
    public Result deleteEmp(@RequestParam List<Integer> ids) {
        log.info("删除员工，ID列表：{}", ids);
        empService.deleteEmp(ids);
        return Result.success();
    }

    /**
     * 获取员工信息
     * 以及工作经历
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getEmp(@PathVariable Integer id) {
        log.info("获取员工信息，ID：{}", id);
        Emp emp = empService.getEmpById(id);
        return Result.success(emp);
    }

    /**
     * 更新员工信息
     * 以及工作经历（先删后添）
     * @param entity
     * @return
     */
    @PutMapping
    public Result updateEmp(@RequestBody Emp entity) {
        log.info("更新员工，参数：{}", entity);
        empService.updateEmp(entity);
        return Result.success();
    }

}
