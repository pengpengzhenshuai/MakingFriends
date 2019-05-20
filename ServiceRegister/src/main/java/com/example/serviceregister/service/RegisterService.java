package com.example.serviceregister.service;

import com.makingfriends.entity.entity.User;

public interface RegisterService {

    int insertSelective(User user);
}
