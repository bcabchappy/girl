package com.imooc.demo.handle;

import com.imooc.demo.domain.Result;
import com.imooc.demo.exception.GirlException;
import com.imooc.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle  {

    private final static Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);

    //因为类上没有RestController，需要添加ResponseBody
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException= (GirlException) e;
            return ResultUtil.error(girlException.getCode(),e.getMessage());
        }else{
            logger.error("[系统异常]:{}",e);//方便查错，抛出的是自己写的异常，无异常详细信息
            return ResultUtil.error(-1,"未知错误");
        }

    }
}
