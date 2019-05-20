package com.makingfriends.serviceregister.service;

import com.makingfriends.entity.User;

public interface RegisterService {

    int insertSelective(User user);
}
