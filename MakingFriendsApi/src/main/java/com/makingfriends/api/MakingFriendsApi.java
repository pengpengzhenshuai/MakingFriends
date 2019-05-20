package com.makingfriends.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableSwagger2//启用Swagger
@EnableDiscoveryClient //发现服务
@EnableFeignClients //启用Feign
public class MakingFriendsApi {

    public static void main(String[] args) {
        SpringApplication.run(MakingFriendsApi.class, args);
    }

}
