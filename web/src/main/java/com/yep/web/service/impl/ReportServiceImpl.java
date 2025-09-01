package com.yep.web.service.impl;

import com.yep.web.service.ReportService;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yep.web.mapper.EmpMapper;
import com.yep.web.mapper.StudentMapper;
import com.yep.web.pojo.DegreeOption;
import com.yep.web.pojo.JobOption;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 获取员工职位数据
     * @return
     * 员工职位数据
     */
    @Override
    public JobOption getEmpJobData() {
        // 返回[{"name": "班主任"}, {"count": 10}...]
        List<Map<String, Object>> countEmpJobData = empMapper.countEmpJobData();
        List<Object> jobNames = countEmpJobData.stream().map(dataMap -> dataMap.get("job_name")).toList();
        List<Object> jobCounts = countEmpJobData.stream().map(dataMap -> dataMap.get("count")).toList();

        JobOption jobOption = new JobOption();
        jobOption.setJobList(jobNames);
        jobOption.setDataList(jobCounts);
        return jobOption;
    }

    /**
     * 获取员工性别数据
     * @return
     */
    @Override
    public List<Map<String, Object>> getGenderData() {
        return empMapper.countEmpGenderData();
    }

    /**
     * 获取班级人数
     * @return
     */
    @Override
    public List<Map<String, Object>> getClassStudentCount() {
        return studentMapper.countClassStudent();
    }

    /**
     * 获取学历人数
     * @return
     */
    @Override
    public DegreeOption getDegreeStudentCount() {
        List<Map<String, Object>> countStuDegreeData = studentMapper.countStuDegreeData();
        List<Object> degreeName = countStuDegreeData.stream().map(dataMap -> dataMap.get("degree_name")).toList();
        List<Object> studentCount = countStuDegreeData.stream().map(dataMap -> dataMap.get("student_count")).toList();

        DegreeOption degreeOption = new DegreeOption();
        degreeOption.setDegreeList(degreeName);
        degreeOption.setDataList(studentCount);
        return degreeOption;
    }

}
