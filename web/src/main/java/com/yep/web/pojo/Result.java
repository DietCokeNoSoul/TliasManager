package com.yep.web.pojo;

import lombok.Data;

@Data
public class Result {
    private Integer code;
    private String message;
    private Object data;

    // 成功响应，无数据
    public static Result success() {
        Result result = new Result();
        result.setCode(200);
        result.setMessage("Success");
        result.setData(null);
        return result;
    }

    // 成功响应，有数据
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(200);
        result.setMessage("Success");
        result.setData(data);
        return result;
    }

    // 失败响应
    public static Result error(String message) {
        Result result = new Result();
        result.setCode(500);
        result.setMessage(message);
        result.setData(null);
        return result;
    }

    // 自定义响应
    public static Result custom(Integer code, String message, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
