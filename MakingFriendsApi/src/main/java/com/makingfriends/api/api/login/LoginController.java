package com.makingfriends.api.api.login;

import com.example.makingcommon.util.JsonBean;
import com.makingfriends.api.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

@RestController
@Api(value = "登录相关操作",tags = "登录相关")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @CrossOrigin
    @ApiOperation(value = "输入密码登录",notes = "通过手机号密码登录")
    @GetMapping("login.do")
    public JsonBean login(@RequestParam("phone") String phone, @RequestParam("password") String password){
        return loginService.login(phone, password);

    }

    @CrossOrigin
    @ApiOperation(value = "获取验证码",notes = "传入一个手机号获取验证码")
    @GetMapping("randomCode.do")
    public JsonBean randomCode(String phone){
       return  loginService.randomCode(phone);
    }

    @CrossOrigin
    @ApiOperation(value = "输入手机号验证码登录",notes = "通过手机号验证码登录")
    @GetMapping("login1.do")
    public JsonBean login1(String phone){
       return loginService.login1(phone);
    }
}
