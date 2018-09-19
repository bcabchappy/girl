package com.imooc.demo.repository;

import com.imooc.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //通常年龄来查询
    public List<Girl> findByAge(Integer age);
}