package com.yep.web.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yep.web.mapper.StudentMapper;

import com.yep.web.pojo.PageResult;
import com.yep.web.pojo.Student;
import com.yep.web.pojo.StudentQueryParam;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 获取学生列表
     */
    @Override
    public PageResult<Student> list(StudentQueryParam studentQueryParam) {
        // 设置分页参数
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        // 查询列表
        List<Student> studentList = studentMapper.list(studentQueryParam);
        // 转换为分页对象
        Page<Student> p = (Page<Student>) studentList;
        return new PageResult<Student>(p.getTotal(), p.getResult());
    }

    /**
     * 删除学生
     */
    @Override
    public void deleteStu(List<Integer> ids) {
        studentMapper.delete(ids);
    }

    /**
     * 创建学生
     */
    @Override
    public void createStudent(Student entity) {
        studentMapper.insert(entity);
    }

    /**
     * 获取学生
     */
    @Override
    public Student getStudent(Integer id) {
        return studentMapper.getById(id);
    }

    /**
     * 更新学生
     */
    @Override
    public void updateStudent(Student entity) {
        studentMapper.update(entity);
    }

}
