package com.imooc.demo.controller;

import com.imooc.demo.domain.Girl;
import com.imooc.demo.domain.Result;
import com.imooc.demo.repository.GirlRepository;
import com.imooc.demo.service.GirlService;
import com.imooc.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    //http://127.0.0.1:8080/girls
    @GetMapping(value="/girls")
    public List<Girl> girlList(){
//        List<Girl> list=girlRepository.findAll();
        System.out.println("~~~~~~girlList ");
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girlAdd")
    public Girl girlAdd(@RequestParam("age") Integer age,
                          @RequestParam("cupSize") String cupSize){
        Girl g=new Girl();
        g.setAge(age);
        g.setCupSize(cupSize);
       return girlRepository.save(g);
    }

    @PostMapping(value = "/girlAdd2")
    public Result<Girl> girlAdd2(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){

            Result result=new Result();
            result.setCode(1);
            System.out.println(bindingResult.getFieldErrors());
            return ResultUtil.error(1,bindingResult.getFieldErrors().toString());
        }
        Girl g=new Girl();
        g.setAge(girl.getAge());
        g.setCupSize(girl.getCupSize());

        return ResultUtil.success(girlRepository.save(g));
    }

    @GetMapping(value = "grilFindOne/{id}")
    public Girl grilFindOne(@PathVariable("id") Integer id){
        Girl g=new Girl();
        g.setId(id);
        Optional<Girl> op=girlRepository.findById(id);
      return  op.get();
    }

    //使用put访问时，在http中不能使用form-data,应该使用x-www.form-urlencoded
    @PutMapping(value = "/girlUpdate")
    public Girl girlUpdate(@RequestParam("age") Integer age,
                           @RequestParam("id") Integer id,
                           @RequestParam("cupSize") String cupSize){
        Girl g=new Girl();
        g.setId(id);
        g.setCupSize(cupSize);
        g.setAge(age);
        return girlRepository.save(g);
    }

    @DeleteMapping(value = "/girlDel/{id}")
    public String girlDel(@PathVariable("id") Integer id){
        Girl g=new Girl();
        g.setId(id);
        girlRepository.delete(g);
        return g.getId().toString();
    }

    //400
//    @GetMapping(value = "/findByAge/{age}")
//    public List<Girl> findByAge(@RequestParam("age") Integer age){
//        return girlRepository.findByAge(age);
//    }

    //http://127.0.0.1:8080/girl/age/18
    @GetMapping(value = "/girl/age/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PutMapping(value = "/girls/two")
    public void insertTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value="girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

    @GetMapping(value="girls/findOne2/{id}")
    public void findOne2(@PathVariable("id") Integer id) throws Exception {
        girlService.findOne2(id);
    }

}
