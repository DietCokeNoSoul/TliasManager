package com.yep.web.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobOption {
    private List jobList;// 职位列表
    private List dataList;// 数据列表
}
