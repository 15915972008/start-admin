package com.start.startcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.start.*"})
public class StartCoreApplication {

    public static void main(String[] args) {

        SpringApplication.run(StartCoreApplication.class, args);
    }

}
