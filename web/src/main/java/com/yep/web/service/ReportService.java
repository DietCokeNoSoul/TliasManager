package com.yep.web.service;

import java.util.List;
import java.util.Map;

import com.yep.web.pojo.JobOption;

public interface ReportService {

    public JobOption getEmpJobData();

    public List<Map<String, Object>> getGenderData();

}
