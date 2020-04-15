package com.example.wenyb.common;

public class Result<T> {
    /**错误码.*/
    private Integer code;
    /**错误提示.*/
    private String msg;
    /**返回的数据.*/
    T data;

    public Result() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}