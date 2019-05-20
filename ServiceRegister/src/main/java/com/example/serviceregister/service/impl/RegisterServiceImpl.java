package com.example.serviceregister.service.impl;

import com.example.serviceregister.dao.RegisterDao;
import com.example.serviceregister.service.RegisterService;
import com.makingfriends.entity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterDao registerDao;

    @Override
    public int insertSelective(User user) {
        User user1 = registerDao.selectUserByPhone(user.getPhone());
        if (user1 == null){
            return registerDao.insertSelective(user);
        }else {
            throw new RuntimeException("用户名已存在");
        }

    }
}
