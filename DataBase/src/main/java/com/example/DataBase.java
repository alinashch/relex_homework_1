package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = "com.example")
@Configuration
public class DataBase {
    public static void main(String[] args) {
        SpringApplication.run(DataBase.class, args);
    }

}
