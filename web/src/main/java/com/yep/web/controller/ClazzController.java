package com.yep.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yep.web.pojo.Clazz;
import com.yep.web.pojo.Result;
import com.yep.web.service.ClazzService;

import lombok.extern.slf4j.Slf4j;

/*
 * 班级控制器
 */
@Slf4j
@RestController
@RequestMapping("/clazz")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /**
     * 获取班级列表
     */
    @GetMapping
    public Result listClazz() {
        log.info("获取班级数据");
        List<Clazz> clazzList = clazzService.findAll();
        return Result.success(clazzList);
    }

    /**
     * 删除班级
     * @param id 班级ID
     */
    @DeleteMapping("/{id}")
    public Result deleteClazz(@PathVariable Integer id) {
        log.info("删除班级数据，id: {}", id);
        clazzService.delete(id);
        return Result.success();
    }

    /**
     * 创建班级
     * @param clazz 班级信息
     */
    @PostMapping
    public Result createClazz(@RequestBody Clazz clazz) {
        log.info("创建班级，参数：{}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    /**
     * 获取班级信息
     * @param id 班级ID
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("获取班级信息，ID：{}", id);
        Clazz clazz = clazzService.getInfo(id);
        return Result.success(clazz);
    }

    /**
     * 更新班级
     * @param clazz 班级信息
     */
    @PutMapping
    public Result updateClazz(@RequestBody Clazz clazz) {
        log.info("更新班级，参数：{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }
}
