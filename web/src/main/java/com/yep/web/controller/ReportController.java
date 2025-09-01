package com.yep.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yep.web.pojo.DegreeOption;
import com.yep.web.pojo.JobOption;
import com.yep.web.pojo.Result;
import com.yep.web.service.ReportService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;
    
    /**
     * 获取员工职位数据
     * @return
     */
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("获取员工职位数据");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /**
     * 获取员工性别数据
     * @return
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        log.info("获取员工性别数据");
        List<Map<String, Object>> genderData = reportService.getGenderData();
        return Result.success(genderData);
    }

    /**
     * 获取班级人数
     * @return
     */
    @GetMapping("/classStudentCount")
    public Result getClassStudentCount() {
        log.info("获取班级人数");
        List<Map<String, Object>> classStudentCount = reportService.getClassStudentCount();
        return Result.success(classStudentCount);
    }

    /**
     * 获取学历人数
     * @return
     */
    @GetMapping("/degreeStudentCount")
    public Result getDegreeStudentCount() {
        log.info("获取学历人数");
        DegreeOption degreeOption = reportService.getDegreeStudentCount();
        return Result.success(degreeOption);
    }

}
