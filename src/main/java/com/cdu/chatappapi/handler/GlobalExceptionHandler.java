package com.cdu.chatappapi.handler;

import com.cdu.chatappapi.utils.JsonResponseUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public JsonResponseUtil<String> handleException(Exception e) {
        JsonResponseUtil<String> exceptionResponse = new JsonResponseUtil<>();

        String message = e.getMessage();
        if (message == null || message.equals("")) {
            message = "服务器内部出错";
        }
        exceptionResponse.setCode(500);
        exceptionResponse.setMessage(message);

        return exceptionResponse;
    }
}
