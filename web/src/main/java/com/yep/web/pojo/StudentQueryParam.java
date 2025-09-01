package com.yep.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentQueryParam {
    private Integer page = 1; // 默认第1页
    private Integer pageSize = 10; // 默认每页10条
    private String name; // 姓名（可选）
    private Integer gender; // 性别（可选）
}