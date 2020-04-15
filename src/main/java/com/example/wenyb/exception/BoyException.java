package com.example.wenyb.exception;

import com.example.wenyb.enums.ResultEnum;

public class BoyException extends RuntimeException {
    private Integer code;

    public BoyException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    public BoyException(Integer code,String msg){
        super(msg);
        this.code = code;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
