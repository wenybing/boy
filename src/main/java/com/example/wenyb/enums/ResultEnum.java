package com.example.wenyb.enums;

public enum ResultEnum {
    UNKONW_ERROR(-1,"未知错误^_^!"),
    PRIMARY_SCHOOL(100,"我猜你还在上小学"),
    MIDDLE_SCHOOL(100,"少年，你还在上中学");
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
