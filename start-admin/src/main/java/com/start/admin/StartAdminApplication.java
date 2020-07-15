package com.start.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.start.*"})
public class StartAdminApplication {

    public static void main(String[] args) {

        SpringApplication.run(StartAdminApplication.class, args);
    }

}
