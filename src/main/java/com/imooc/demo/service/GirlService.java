package com.imooc.demo.service;

import com.imooc.demo.domain.Girl;
import com.imooc.demo.enums.ResultEnum;
import com.imooc.demo.exception.GirlException;
import com.imooc.demo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//Serviceimport org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        //仅仅两条都通过时才会插入，否则无法插入
        //事务无效,将表引擎改为innodb即可
        Girl ga=new Girl();
        ga.setCupSize("AA");
        ga.setAge(56);
        girlRepository.save(ga);

        Girl gb=new Girl();
        gb.setCupSize("BBB");//数据库长度限制为2
        gb.setAge(18);
        girlRepository.save(gb);
    }

    public void getAge(Integer id) throws Exception {
       Girl g= girlRepository.findById(id).get();
       Integer age=g.getAge();
       if(age<10){
           // throw new Exception("还在上小学吧");
//           throw new GirlException(100,"还在上小学吧");
           throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
       }else if((age > 10) && (age < 16)){
//           throw new Exception("还在上中学吧");
           //throw new GirlException(101,"还在上中学吧");
           throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
       }else if(age > 16 && age<24){
//           throw new Exception("你在上什么？");
         //  throw new GirlException(102,"你在上什么？");
           throw new GirlException(ResultEnum.UNKONW_ERROW);
       }
    }

    /**
     *
     * @param id
     * @return
     */
    public Girl findOne2(Integer id){
        //return girlRepository.getOne(id);
        return girlRepository.findById(id).get();
    }
}
