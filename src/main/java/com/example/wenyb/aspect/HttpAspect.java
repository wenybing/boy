package com.example.wenyb.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);



    @Pointcut("execution(public * com.example.wenyb.controller.BoyController.*(..))")
    public void log(){

    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("请求处理前******");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("method={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //args
        logger.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter(){
        logger.info("请求处理后*****");
    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturn(Object object){
        logger.info("object={}",object);
    }

   /* @Before("log()")
    public void doBefore(){
        System.out.println("请求处理前----");
    }
    @After("log()")
    public void doAfter(){
        System.out.println("请求处理后----");
    }*/

   /* @Before("execution(public * com.example.wenyb.controller.BoyController.searchBoyList(..))")
    public void beforeLog(){
        System.out.println("请求处理前。。。");
    }
    @After("execution(public * com.example.wenyb.controller.BoyController.searchBoyList(..))")
    public void afterLog(){
        System.out.println("请求处理后。。。");
    }*/
}
