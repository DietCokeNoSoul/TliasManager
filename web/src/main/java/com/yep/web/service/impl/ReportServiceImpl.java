package com.yep.web.service.impl;

import com.yep.web.service.ReportService;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yep.web.mapper.EmpMapper;
import com.yep.web.pojo.JobOption;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

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

    @Override
    public List<Map<String, Object>> getGenderData() {
        return empMapper.countEmpGenderData();
    }

}
