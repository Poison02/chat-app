package com.cdu.chatappapi.utils;

public class JsonResponseUtil<T> {
    public Integer code;
    public String message;
    public T data;

    public JsonResponseUtil() {
    }

    public JsonResponseUtil(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JsonResponseUtil(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
