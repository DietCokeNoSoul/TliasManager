package com.yep.web.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpExpr {
    private Integer id;
    private LocalDate begin;
    private LocalDate end;
    private String company;
    private String job;
    private Integer empId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
