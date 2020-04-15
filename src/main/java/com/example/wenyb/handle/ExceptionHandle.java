package com.example.wenyb.handle;

import com.example.wenyb.common.Result;
import com.example.wenyb.exception.BoyException;
import com.example.wenyb.utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    /*@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handlerException(Exception e){
        return ResultUtils.error(100,e.getMessage());
    }*/

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handlerException(Exception e){
        if(e instanceof BoyException){
            BoyException boyException = (BoyException) e;
            return ResultUtils.error(boyException.getCode(),boyException.getMessage());
        }else{
            return ResultUtils.error(-1,e.getMessage());
        }
    }
}
