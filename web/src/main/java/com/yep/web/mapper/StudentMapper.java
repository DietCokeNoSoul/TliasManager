package com.yep.web.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.yep.web.pojo.Student;
import com.yep.web.pojo.StudentQueryParam;

@Mapper
public interface StudentMapper {

    List<Student> list(StudentQueryParam studentQueryParam);

    void delete(List<Integer> ids);

    void insert(Student entity);

    void update(Student entity);

    Student getById(Integer id);

    List<Map<String, Object>> countClassStudent();

    /**
     * 统计学生学历分布
     * 
     * @return 学历分布数据
     */
    List<Map<String, Object>> countStuDegreeData();
}
