package com.example.serverlogin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.example.serverlogin.dao")
public class ServerLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerLoginApplication.class, args);
    }

}
