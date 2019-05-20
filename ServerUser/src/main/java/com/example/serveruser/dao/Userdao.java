package com.example.serveruser.dao;


import com.example.serveruser.vo.VDynamic;
import com.example.serveruser.vo.VUser;
import com.makingfriends.entity.entity.Action;
import com.makingfriends.entity.entity.Comments;
import com.makingfriends.entity.entity.Dynamic;
import com.makingfriends.entity.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;


/**
 * Created by Administrator on 2019/4/27.
 */
public interface Userdao {

    @Select("select * from user where phone = #{phone}")
    User selectUserByPhone(String phone);

    @Select("select distinct position from user")
    List<User> findPosition();

    @Select("select * from user where position = #{position}")
    public List<User> findByPosition(@Param("position") String position);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);


    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    /*@Update("update user set name = #{name},age = #{age} ,idcard = #{idcard},email = #{email} where id = #{id}")*/

    void editInfo(User user);

    @Select("select password from user where phone = #{phone}")
    String  findPassword(String phone);

    @Update("update user set password = #{newpassword} where phone = #{phone}")
    void changePassword(@Param("phone") String phone, @Param("newpassword") String newpassword);

    @Select("SELECT u.name,d.dname,d.ddesc,d.dtime,ud.flag FROM \n" +
            "user u\n" +
            "INNER JOIN user_dynamic ud\n" +
            "on u.phone = ud.lphone\n" +
            "INNER JOIN dynamic d\n" +
            "on ud.uphone = d.uphone\n" +
            "WHERE u.phone = #{phone} and ud.flag = 1")
    List<VUser> focusPerson(String phone);

    List<Action> findAction1(@Param("phone") String phone);

    List<Action> findAction2(String phone);

    void addDynamic(Dynamic dy);

    @Select("select d.id,d.dname,u.img,d.dtime,d.ddesc,d.flag,d.photo from dynamic d\n" +
            "\t\tinner JOIN user u\n" +
            "\t\ton d.uphone = u.phone\n" +
            "\t\twhere d.flag != 2")
    List<VDynamic> dynamicList();

    @Select("select * from user_dynamic where lphone = #{phone1} and uphone = #{phone2}")
    Integer focus1(@Param("phone1") String phone1, @Param("phone2") String phone2);

    @Insert("insert into user_dynamic (lphone,uphone,flag) values (#{phone1},#{phone2},1)")
    void focus2(@Param("phone1") String phone1, @Param("phone2") String phone2);

    @Update("update user_dynamic set flag = 1 where lphone = #{phone1} and uphone = #{phone2}")
    void focus3(@Param("phone1") String phone1, @Param("phone2") String phone2);

    @Select("select * from user_dynamic where lphone = #{phone1} and uphone = #{phone2}")
    Integer keepOut1(@Param("phone1") String phone1, @Param("phone2") String phone2);

    @Insert("insert into user_dynamic (lphone,uphone,flag) values (#{phone1},#{phone2},2)")
    void keepOut2(@Param("phone1") String phone1, @Param("phone2") String phone2);

    @Update("update user_dynamic set flag = 2 where lphone = #{phone1} and uphone = #{phone2}")
    void keepOut3(@Param("phone1") String phone1, @Param("phone2") String phone2);

    @Insert("insert into comments (did,comments,ctime) values (#{did},#{comments},#{ctime})")
    void addComments(Comments c);

    void updateUser(User user);

    List<User> findCondition(User user);

    User findbyphone(String phone);

    List<Comments> findcomments(int did);

    List<Dynamic> finddecbyphone(String phone);
}
