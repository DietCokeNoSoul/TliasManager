package com.yep.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yep.web.pojo.Dept;
import com.yep.web.pojo.Result;
import com.yep.web.service.DeptService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {


    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result listDept() {
        log.info("获取部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result deleteDept(@PathVariable Integer id) {
        deptService.delete(id);
        log.info("删除部门，ID：{}", id);
        return Result.success();
    }

    @PostMapping
    public Result createDept(@RequestBody Dept entity) {
        deptService.save(entity);
        log.info("创建部门，参数：{}", entity);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("获取部门信息，ID：{}", id);
        Dept dept = deptService.getInfo(id);
        return Result.success(dept);
    }
    
    @PutMapping
    public Result updateDept(@RequestBody Dept entity) {
        deptService.update(entity);
        log.info("更新部门，参数：{}", entity);
        return Result.success();
    }
}
