package com.example.serviceregister;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.example.serviceregister.dao")
public class ServiceRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegisterApplication.class, args);
    }

}
