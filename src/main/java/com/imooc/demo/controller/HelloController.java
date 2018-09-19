package com.imooc.demo.controller;

import com.imooc.demo.properties.GrilProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hc")
public class HelloController {

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

    //http://127.0.0.1:8080/hc/hi,不写method，默认get或post都可以访问到
    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    public String hello(){
        return "hello world:"+girlProperties.getCupSize()+","+girlProperties.getAge()+"\n"+content;
    }

    @RequestMapping(value = "/say/{id}",method = RequestMethod.GET)
    public String hello(@PathVariable("id") Integer id){
        return "id:"+id;
    }

    //http://127.0.0.1:8080/hc/44/say
    @RequestMapping(value = "/{id}/say",method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id){
        return "id:"+id;
    }

    //http://127.0.0.1:8080/hc/say?id=900
    @RequestMapping(value = "/say1",method = RequestMethod.GET)
    public String say1(@RequestParam("id") Integer myid){
        return "myid:"+myid;
    }

    //http://127.0.0.1:8080/hc/say2?id=
    @RequestMapping(value = "/say2",method = RequestMethod.GET)
    public String say2(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myid){
        return "myid:"+myid;
    }

    @GetMapping("/say3")   //组合注解，相当于@RequestMapping(value = "/say2",method = RequestMethod.GET)
//    @PostMapping("/say3")
    public String say3(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myid){
        return "myid:"+myid;
    }


}
