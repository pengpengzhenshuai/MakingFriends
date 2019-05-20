package com.makingfriends.api.service;

import com.makingfriends.makingcommon.util.JsonBean;
import com.makingfriends.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "UserProvider")
public interface UserService {

    @GetMapping("findPosition.do")
    JsonBean UserPosition();

    @GetMapping("findByPosition.do")
    JsonBean findByPosition(@RequestParam("position") String position);

    @GetMapping("user/register.do")
    JsonBean register(@RequestParam(value = "phone") String phone, @RequestParam("position") String position, @RequestParam("password") String password);

    @PostMapping("editInfo.do")
    JsonBean editInfo(@RequestBody User user);

    @GetMapping("changePassword.do")
    JsonBean changePassword(@RequestParam("phone") String phone,@RequestParam("password") String password,@RequestParam("newpassword") String newpassword);

    @GetMapping("focusPerson.do")
    JsonBean focusPerson(@RequestParam("phone") String phone);

    @GetMapping("action1.do")
    JsonBean findAction1(@RequestParam("phone")String phone);

    @GetMapping("action2.do")
    JsonBean findAction2(@RequestParam("phone") String phone);

    @RequestMapping(value = "photoupload.do", method = RequestMethod.POST)
    JsonBean uploadHead(@RequestParam("file") MultipartFile file);

    @GetMapping("addDynamic.do")
    JsonBean addDynamic(@RequestParam("uphone") String uphone,@RequestParam("photo") String photo, @RequestParam("ddesc") String ddesc);

    @GetMapping("dynamicList.do")
    JsonBean dynamicList();

    @GetMapping("focus.do")
    JsonBean focus(@RequestParam("phone1") String phone1, @RequestParam("phone2")String phone2);

    @GetMapping("keepOut.do")
    JsonBean keepOut(@RequestParam("phone1") String phone1,@RequestParam("phone2")String phone2);

    @GetMapping("addComments.do")
    JsonBean addComments(@RequestParam("id") Integer id, @RequestParam("comments")String comments);
    @RequestMapping(value = "addUser.do", method = RequestMethod.POST)
    JsonBean uploadHead(@RequestParam("file") MultipartFile file,@RequestBody  User user);

    //在介绍页中的按条件筛选
    @PostMapping("findCondition.do")
    JsonBean findCondition(@RequestBody User user);

    @PostMapping("findByphone.do")
    JsonBean findByPhone(@RequestParam("phone")String phone);

    @PostMapping(value = "addbaseUser.do")
    JsonBean upload(@RequestBody User user);

    @GetMapping(value = "findcomment.do")
    JsonBean showcomment(@RequestParam("did") int did);

    @PostMapping("findDynByPhone.do")
    JsonBean findDynByPhone(@RequestParam("phone") String phone);
}
