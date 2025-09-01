package com.yep.web.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Violation {
    private Integer id;
    private Integer studentId;
    private String description;
    private Integer score;
    private LocalDate vioDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
