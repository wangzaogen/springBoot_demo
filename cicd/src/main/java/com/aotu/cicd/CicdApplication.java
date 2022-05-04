package com.aotu.cicd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.aotu.cicd.mapper")
public class CicdApplication {

    public static void main(String[] args) {
        SpringApplication.run(CicdApplication.class, args);
    }

}
