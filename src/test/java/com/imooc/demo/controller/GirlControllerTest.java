package com.imooc.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {

    @Autowired
    private GirlController girlController;

    @Autowired
    private MockMvc mvc;

    //仅对方法的测试，而非地址
//    @Test
//    public void girlList() throws Exception {
//       // girlController.findOne2(new Integer(1));
//        girlController.girlList();
//    }

    //测试url,打包时会自动测试用例，mvn clean package,--Dmaven.test.skip=true,此参数可跳过单元测试
    @Test
    public void girlList() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/girls"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//        mvc.perform(MockMvcRequestBuilders.get("/girls"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.content().string("abc"));
    }
}