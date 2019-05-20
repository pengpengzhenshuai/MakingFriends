package com.makingfriends.api.service;

import com.example.makingcommon.util.JsonBean;
import com.makingfriends.entity.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "RegisterProvider")
public interface RegisterService {

    @GetMapping("user/register.do")
    JsonBean register(@RequestParam(value = "phone") String phone, @RequestParam("position") String position, @RequestParam("password") String password);

    @PostMapping(value = "addbaseUser.do")
    JsonBean upload(@RequestBody User user);
}
