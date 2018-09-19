package com.imooc.demo;

import com.imooc.demo.domain.Girl;
import com.imooc.demo.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//表示在测试里跑了;启动spring工程
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void  findOneTest(){
        Girl girl=girlService.findOne2(1);
        //Assert.assertEquals(new Integer(2),girl.getAge());
    }

}
