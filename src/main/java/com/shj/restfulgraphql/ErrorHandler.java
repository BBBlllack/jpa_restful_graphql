package com.shj.restfulgraphql;

import com.shj.restfulgraphql.entity.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler({Exception.class})
    public ApiResponse handler(HttpServletRequest request, Exception e) {
        return ApiResponse.ok(e.getMessage());
    }
}
