package com.makingfriends.serverlogin.dao;



import com.makingfriends.entity.User;
import org.apache.ibatis.annotations.*;


/**
 * Created by Administrator on 2019/4/27.
 */
@Mapper
public interface LoginDao {

    @Select("select * from user where phone = #{phone}")
    User selectUserByPhone(String phone);



}
