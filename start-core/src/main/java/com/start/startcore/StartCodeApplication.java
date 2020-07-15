package com.start.startcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.start.*"})
public class StartCodeApplication {

    public static void main(String[] args) {

        SpringApplication.run(StartCodeApplication.class, args);
    }

}
