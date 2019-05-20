package com.makingfriends.serveruser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//这是一个服务
@MapperScan("com.makingfriends.serveruser.dao")
public class ServerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerUserApplication.class, args);
    }

}
