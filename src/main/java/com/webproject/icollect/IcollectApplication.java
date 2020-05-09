package com.webproject.icollect;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.webproject.icollect.mapper")
public class IcollectApplication {

    public static void main(String[] args) {
        SpringApplication.run(IcollectApplication.class, args);
    }

}
