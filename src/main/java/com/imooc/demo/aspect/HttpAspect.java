package com.imooc.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    //http://127.0.0.1:8080/girls,已拦截
//    @Before("execution(public * com.imooc.demo.controller.GirlController.girlList(..))")
//    public void log(){
//        System.out.println(1111111111);
//    }

//    @Before("execution(public * com.imooc.demo.controller.GirlController.*(..))")
//    public void log(){
//        System.out.println(1111111111);
//    }
//    @After("execution(public * com.imooc.demo.controller.GirlController.*(..))")
//    public void doAfter(){
//            System.out.println(222222222);
//    }

    private final static Logger logger=LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.imooc.demo.controller.GirlController.*(..))")
    public void log(){
        logger.info("1111111111111111");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        //System.out.println(22222222);
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        logger.info("22222222222222222222222222222");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response="+object.toString());
    }
}
