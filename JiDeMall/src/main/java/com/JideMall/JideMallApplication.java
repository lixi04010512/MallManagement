package com.JideMall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.JideMall.mapper")
@SpringBootApplication
public class JideMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(JideMallApplication.class, args);
    }

}
