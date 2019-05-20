package com.makingfriends.serverlogin.service.impl;

import com.makingfriends.serverlogin.dao.LoginDao;
import com.makingfriends.serverlogin.service.LoginService;
import com.makingfriends.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2019/4/27.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public User login(String phone, String password) {
        User user = loginDao.selectUserByPhone(phone);
        if(user == null){
            throw new RuntimeException("用户名错误");
        }
        if(!user.getPassword().equals(password)){
            throw new RuntimeException("密码错误");
        }
        return user;
    }

    @Override
    public User login1(String phone) {
        User user = loginDao.selectUserByPhone(phone);
        if(user == null){
            throw new RuntimeException("用户名错误");
        }
        return user;
    }

    public static int randomCode(){
        return (int)(Math.random()*8999)+1000;
    }




}
