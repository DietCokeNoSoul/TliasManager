package com.yep.web.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer gender;
    private String phone;
    private Integer job;
    private Integer salary;
    private String image;
    private LocalDate entryTime;
    private Integer deptId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    //封装部门名称
    private String deptName;
    //封装员工经历
    private List<EmpExpr> empExprList;
}
