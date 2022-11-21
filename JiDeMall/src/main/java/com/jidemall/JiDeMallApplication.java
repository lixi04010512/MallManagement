package com.jidemall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jidemall.mapper")
public class JiDeMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiDeMallApplication.class, args);
    }

}
