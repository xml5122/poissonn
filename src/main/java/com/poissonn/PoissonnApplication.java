package com.poissonn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.poissonn.dao")
public class PoissonnApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoissonnApplication.class, args);
    }

}
