package com.example.mbp0626;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching//开启缓存注解
@MapperScan("com.example.mbp0626.dao")
@SpringBootApplication
public class Mbp0626Application {

    public static void main(String[] args) {
        SpringApplication.run(Mbp0626Application.class, args);
    }

}
