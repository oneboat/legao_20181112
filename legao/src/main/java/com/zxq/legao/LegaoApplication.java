package com.zxq.legao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.zxq.legao.dao")
public class LegaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LegaoApplication.class, args);
    }
}
