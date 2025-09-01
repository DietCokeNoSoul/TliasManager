package com.yep.web.service;

import java.util.List;

import com.yep.web.pojo.PageResult;
import com.yep.web.pojo.Student;
import com.yep.web.pojo.StudentQueryParam;


public interface StudentService {

    PageResult<Student> list(StudentQueryParam studentQueryParam);

    void deleteStu(List<Integer> ids);

    void createStudent(Student entity);

    void updateStudent(Student entity);

    Student getStudentById(Integer id);

}
