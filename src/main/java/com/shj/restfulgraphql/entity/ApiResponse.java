package com.shj.restfulgraphql.entity;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private Integer code;
    private T data;
    private String msg;

    public static <T> ApiResponse<T> ok(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.code = 200;
        response.data = data;
        response.msg = "ok";
        return response;
    }
}
