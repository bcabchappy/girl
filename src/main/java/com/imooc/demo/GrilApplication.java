package com.imooc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class GrilApplication {

    public static void main(String[] args) {

        SpringApplication.run(GrilApplication.class, args);
    }
}
