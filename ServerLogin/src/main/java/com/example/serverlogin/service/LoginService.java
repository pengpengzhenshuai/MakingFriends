package com.example.serverlogin.service;

import com.makingfriends.entity.entity.User;



/**
 * Created by Administrator on 2019/4/27.
 */
public interface LoginService {

   User login(String phone, String password);

   User login1(String phone);


}
