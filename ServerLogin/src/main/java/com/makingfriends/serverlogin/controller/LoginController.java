package com.makingfriends.serverlogin.controller;


import com.makingfriends.makingcommon.util.CommonInfo;
import com.makingfriends.makingcommon.util.JsonBean;
import com.makingfriends.serverlogin.service.LoginService;
import com.makingfriends.serverlogin.service.impl.LoginServiceImpl;
import com.makingfriends.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


/**
 * Created by Administrator on 2019/4/27 0027.
 */
@RestController

public class LoginController {
    @Autowired
    private LoginService loginService;
    //登录
    @CrossOrigin
    @GetMapping("login.do")
    public JsonBean login(@RequestParam("phone") String phone, @RequestParam("password") String password, HttpSession session){
        User user = loginService.login(phone,password);
        session.setAttribute(CommonInfo.LOGIN_USER,user);
//        System.out.println((User)session.getAttribute(CommonInfo.LOGIN_USER));
//        System.out.println(session.getId());
        if(user != null){
            return JsonBean.setOK("登录",null);
        }else {
            return JsonBean.setERROR("登录",null);
        }

    }
    //验证码的获取
    @CrossOrigin
    @GetMapping("randomCode.do")
    public JsonBean randomCode(@RequestParam("phone") String phone){
        if(phone != null){
            return JsonBean.setOK("验证码", LoginServiceImpl.randomCode());
        }else {
            return JsonBean.setERROR("发送验证码失败",null);
        }
    }
    //手机号登录
    @CrossOrigin
    @GetMapping("login1.do")
    public JsonBean login1(@RequestParam("phone") String phone){
        User user = loginService.login1(phone);
        if(user != null){
            return JsonBean.setOK("登录成功",null);
        }else {
            return JsonBean.setERROR("登录失败",null);
        }

    }

}
