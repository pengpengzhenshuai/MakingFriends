package com.example.serveruser.service;


import com.example.makingcommon.util.JsonBean;
import com.example.serveruser.vo.VDynamic;
import com.example.serveruser.vo.VUser;
import com.makingfriends.entity.entity.Action;
import com.makingfriends.entity.entity.Comments;
import com.makingfriends.entity.entity.Dynamic;
import com.makingfriends.entity.entity.User;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Administrator on 2019/4/27.
 */
public interface UserService {

    List<User> findPosition();

    List<User> findByPosition(String position);



    List<User> findCondition(User user);

    void editInfo(User user);

    void findPassword(String phone, String password);

    void changePassword(String phone, String newpassword);

    List<VUser> focusPerson(String phone);

    List<Action> findAction1(String phone);

    List<Action> findAction2(String phone);

    void addDynamic(Dynamic dy);

    List<VDynamic> dynamicList();

    void focus(String phone1, String phone2);

    void keepOut(String phone1, String phone2);

    void addComments(Comments c);

    User findByPhone(String phone);

    List<Comments> findcomments(int did);

    List<Dynamic> finddecbyphone(String phone);

    JsonBean uploadHead(MultipartFile file,  User user);

    JsonBean uploadHead(@RequestParam("file") MultipartFile file);
}
