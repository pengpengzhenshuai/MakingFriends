package com.makingfriends.serveruser.controller;


import com.makingfriends.makingcommon.util.JsonBean;
import com.makingfriends.serveruser.service.UserService;
import com.makingfriends.serveruser.vo.VDynamic;
import com.makingfriends.serveruser.vo.VUser;
import com.makingfriends.entity.Action;
import com.makingfriends.entity.Comments;
import com.makingfriends.entity.Dynamic;
import com.makingfriends.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;





/**
 * Created by Administrator on 2019/4/27 0027.
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @GetMapping("findPosition.do")
    public JsonBean UserPosition(){
        List<User> list = userService.findPosition();
        return JsonBean.setOK("查找成功",list);
    }

    @CrossOrigin
    @GetMapping("findByPosition.do")
    public JsonBean findByPosition(@RequestParam("position") String position) {
        List<User> list = userService.findByPosition(position);
        return JsonBean.setOK("查找成功", list);
    }

    @CrossOrigin
    @PostMapping("editInfo.do")
    public JsonBean editInfo(@RequestBody User user) {
        userService.editInfo(user);
        return JsonBean.setOK("编辑成功", null);
    }

    @CrossOrigin
    @GetMapping("changePassword.do")
    public JsonBean changePassword(@RequestParam("phone") String phone,@RequestParam("password") String password,@RequestParam("newpassword") String newpassword) {
        userService.findPassword(phone,password);
        userService.changePassword(phone,newpassword);
        return JsonBean.setOK("编辑成功", null);
    }

    @CrossOrigin
    @GetMapping("focusPerson.do")
    public JsonBean focusPerson(@RequestParam("phone") String phone) {
        List<VUser> list = userService.focusPerson(phone);
        return JsonBean.setOK("查找成功", list);
    }

    @CrossOrigin
    @GetMapping("action1.do")
    public JsonBean findAction1(@RequestParam("phone") String phone) {
        List<Action> list = userService.findAction1(phone);
        return JsonBean.setOK("查找成功", list);
    }

    @CrossOrigin
    @GetMapping("action2.do")
    public JsonBean findAction2(@RequestParam("phone") String phone) {
        List<Action> list = userService.findAction2(phone);
        return JsonBean.setOK("查找成功", list);
    }
    @CrossOrigin
    @RequestMapping(value = "photoupload.do", method = RequestMethod.POST)
    public JsonBean uploadHead(@RequestParam("file") MultipartFile file) {

        return userService.uploadHead(file);
    }

    @CrossOrigin
    @GetMapping("addDynamic.do")
    public JsonBean addDynamic(@RequestParam("uphone") String uphone,@RequestParam("photo") String photo,@RequestParam("ddesc") String ddesc) {
        Dynamic dy = new Dynamic();
        dy.setDname("最新动态");
        dy.setUphone(uphone);
        dy.setPhoto(photo);
        dy.setDdesc(ddesc);
        dy.setDtime(new Date());
        dy.setFlag(0);
        userService.addDynamic(dy);
        return JsonBean.setOK("新增成功", null);
    }

    @CrossOrigin
    @GetMapping("dynamicList.do")
    public JsonBean dynamicList() {
        List<VDynamic> list = userService.dynamicList();
        return JsonBean.setOK("查找成功", list);
    }
    @CrossOrigin

    @GetMapping("focus.do")
    public JsonBean focus(@RequestParam("phone1") String phone1,@RequestParam("phone2") String phone2) {
        userService.focus(phone1,phone2);
        return JsonBean.setOK("关注成功", null);
    }

    @CrossOrigin
    @GetMapping("keepOut.do")
    public JsonBean keepOut(@RequestParam("phone2") String phone1,@RequestParam("phone2") String phone2) {
        userService.keepOut(phone1,phone2);
        return JsonBean.setOK("屏蔽成功", null);
    }

    @CrossOrigin
    @GetMapping("addComments.do")
    public JsonBean addComments(@RequestParam("id") Integer id,@RequestParam("comments") String comments) {
        Comments c = new Comments();
        c.setCtime(new Date());
        c.setComments(comments);
        c.setDid(id);
        userService.addComments(c);
        return JsonBean.setOK("新增成功", null);
    }

    @CrossOrigin
    @RequestMapping(value = "addUser.do", method = RequestMethod.POST)
    public JsonBean uploadHead(@RequestParam("file") MultipartFile file,@RequestBody  User user) {
        return userService.uploadHead(file, user);
    }

    @CrossOrigin
    //在介绍页中的按条件筛选
    @PostMapping("findCondition.do")
    public JsonBean findCondition(@RequestBody User user) {
        List<User> list = userService.findCondition(user);
        return JsonBean.setOK("查找", list);
    }

    @CrossOrigin
    @PostMapping("findByphone.do")
    public JsonBean findByPhone(@RequestParam("phone")String phone){
        User user = userService.findByPhone(phone);
        return JsonBean.setOK("查找成功", user);
    }


    @CrossOrigin
    @GetMapping(value = "findcomment.do")
    public JsonBean showcomment(@RequestParam("did") int did) {
        List<Comments> list = userService.findcomments(did);
        return JsonBean.setOK("查询成功",list);
    }

    @CrossOrigin
    @PostMapping("findDynByPhone.do")
    public JsonBean findDynByPhone(@RequestParam("phone") String phone){
        List<Dynamic> list = userService.finddecbyphone(phone);
        return JsonBean.setOK("查找成功", list);
    }

}
