package com.example.serviceregister.dao;

import com.makingfriends.entity.entity.User;
import org.apache.ibatis.annotations.Select;
public interface RegisterDao {
    @Select("select * from user where phone = #{phone}")
    User selectUserByPhone(String phone);

    int insertSelective(User record);
}
