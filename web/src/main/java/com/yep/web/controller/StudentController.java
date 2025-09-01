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

import com.yep.web.pojo.PageResult;
import com.yep.web.pojo.Result;
import com.yep.web.pojo.Student;
import com.yep.web.pojo.StudentQueryParam;
import com.yep.web.service.impl.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 获取学生列表
     * @param studentQueryParam 查询参数
     */
    @GetMapping("/list")
    public Result list(StudentQueryParam studentQueryParam) {
        log.info("获取学生列表");
        PageResult<Student> list = studentService.list(studentQueryParam);
        return Result.success(list);
    }

    /**
     * 删除学生
     * @param ids 学生ID列表
     */
    @DeleteMapping
    public Result deleteStudent(@RequestBody List<Integer> ids) {
        log.info("删除学生，ids: {}", ids);
        studentService.deleteStu(ids);
        return Result.success();
    }

    /**
     * 创建学生
     * @param entity 学生实体
     */
    @PostMapping
    public Result createStudent(@RequestBody Student entity) {
        log.info("创建学生，参数：{}", entity);
        studentService.createStudent(entity);
        return Result.success();
    }

    @PutMapping
    public Result updateStudent(@RequestBody Student entity) {
        log.info("更新学生，参数：{}", entity);
        studentService.updateStudent(entity);
        return Result.success();
    }
}