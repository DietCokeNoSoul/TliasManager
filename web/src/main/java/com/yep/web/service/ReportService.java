package com.yep.web.service;

import java.util.List;
import java.util.Map;

import com.yep.web.pojo.DegreeOption;
import com.yep.web.pojo.JobOption;

public interface ReportService {

    JobOption getEmpJobData();

    List<Map<String, Object>> getGenderData();

    List<Map<String, Object>> getClassStudentCount();

    DegreeOption getDegreeStudentCount();

}
