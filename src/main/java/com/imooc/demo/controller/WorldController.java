package com.imooc.demo.controller;

import com.imooc.demo.properties.GrilProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WorldController {

    //注入配置文件中的属性
//    @Value("${cupSize}")
//    private String cupSize;
//
//    @Value("${age}")
//    private Integer age;
//
    @Value("${content}")
    private String content;

    @Autowired
    private GrilProperties girlProperties;

    @RequestMapping(value = "/world",method = RequestMethod.GET)
    public String a(){
        return "index";
    }
}
