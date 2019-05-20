package com.makingfriends.serviceregister.controller;

import com.makingfriends.makingcommon.util.JsonBean;
import com.makingfriends.serviceregister.service.RegisterService;
import com.makingfriends.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @CrossOrigin
    @GetMapping("user/register.do")
    public JsonBean register(@RequestParam(value = "phone") String phone, @RequestParam("position") String position, @RequestParam("password") String password){
        User user = new User();
        user.setPhone(phone);
        user.setPosition(position);
        user.setPassword(password);
        int i = registerService.insertSelective(user);
        if (i != 0){
            return JsonBean.setOK("注册成功！",null);
        }else {
            return JsonBean.setERROR("注册失败！",null);
        }
    }

    @CrossOrigin
    @PostMapping(value = "addbaseUser.do")
    public JsonBean upload(@RequestBody User user) {
        int i = registerService.insertSelective(user);
        if (i == 1){
            return JsonBean.setOK("上传成功",null);
        }else{
            return JsonBean.setERROR("上传失败",null);
        }
    }
}
