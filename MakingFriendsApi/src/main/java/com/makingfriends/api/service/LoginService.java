package com.makingfriends.api.service;

import com.makingfriends.makingcommon.util.JsonBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "LoginProvider")
public interface LoginService {

    @GetMapping("login.do")
    JsonBean login(@RequestParam("phone") String phone, @RequestParam("password") String password);

    @GetMapping("randomCode.do")
    JsonBean randomCode(@RequestParam("phone") String phone);

    @GetMapping("login1.do")
    JsonBean login1(@RequestParam("phone") String phone);
}
