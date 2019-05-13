package com.example.serveruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//这是一个服务
public class ServeruserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServeruserApplication.class, args);
    }

}
