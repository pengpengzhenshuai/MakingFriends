package com.makingfriends.api.api.register;


import com.example.makingcommon.util.JsonBean;
import com.makingfriends.api.service.RegisterService;
import com.makingfriends.entity.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "用户注册,及完善user信息包含图片",tags = "用户注册")
public class registerController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("user/register.do")
    @ApiOperation(value = "用户注册",notes = "用户需要传手机号及密码")
    public JsonBean register(@RequestParam(value = "phone") String phone, @RequestParam("position") String position, @RequestParam("password") String password){
        return registerService.register(phone,position,password);
    }

    @PostMapping(value = "addbaseUser.do")
    @ApiOperation(value = "完善user信息包含图片上传base64",notes = "传入图片路径，user信息")
    public JsonBean upload(@RequestBody User user){
        return registerService.upload(user);
    }
}
