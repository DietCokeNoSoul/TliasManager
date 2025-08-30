package com.yep.web.pojo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * 员工查询参数
 */
@Data
public class EmpQueryParam {
    private Integer page = 1;        // 默认第1页
    private Integer pageSize = 10;   // 默认每页10条
    private String name;             // 姓名（可选）
    private Integer gender;          // 性别（可选）
    
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private LocalDate begin;         // 开始时间（可选）
    
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private LocalDate end;           // 结束时间（可选）
}
