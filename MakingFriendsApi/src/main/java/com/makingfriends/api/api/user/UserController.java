package com.makingfriends.api.api.user;

import com.makingfriends.makingcommon.util.JsonBean;
import com.makingfriends.api.service.UserService;
import com.makingfriends.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Api(value = "用户相关操作",tags = "用户相关")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("findPosition.do")
    @ApiOperation(value = "查询所有的职位",notes = "所有的职位")
    public JsonBean UserPosition(){
        return userService.UserPosition();
    }

    @GetMapping("findByPosition.do")
    @ApiOperation(value = "根据职位查询这个职位的人",notes = "传入一个职位，查询该职位的所有人")
    public JsonBean findByPosition(@RequestParam("phone") String position) {
        return  userService.findByPosition(position);
    }

    @PostMapping("editInfo.do")
    @ApiOperation(value = "修改个人信息，补全信息",notes = "编辑个人信息")
    public JsonBean editInfo(@RequestBody User user) {
       return userService.editInfo(user);
    }

    @GetMapping("changePassword.do")
    @ApiOperation(value = "修改密码",notes = "传入手机号，旧密码，新密码")
    public JsonBean changePassword(@RequestParam("phone") String phone,@RequestParam("password")String password,@RequestParam("newpassword") String newpassword) {
        return userService.changePassword(phone,password,newpassword);
    }

    @GetMapping("focusPerson.do")
    @ApiOperation(value = "我的关注",notes = "传入登录人手机号")
    public JsonBean focusPerson(@RequestParam("phone") String phone) {
        return userService.focusPerson(phone);
    }

    @GetMapping("action1.do")
    @ApiOperation(value = "参加的活动",notes = "传入手机号")
    public JsonBean findAction1(@RequestParam("phone") String phone) {
        return userService.findAction1(phone);
    }

    @GetMapping("action2.do")
    @ApiOperation(value = "未参加的活动",notes = "传入手机号")
    public JsonBean findAction2(@RequestParam("phone")String phone) {
        return userService.findAction2(phone);
    }

    @RequestMapping(value = "photoupload.do", method = RequestMethod.POST)
    @ApiOperation(value = "图片上传",notes = "图片上传")
    public JsonBean uploadHead(@RequestParam("file") MultipartFile file) {
        return userService.uploadHead(file);
    }


    @GetMapping("addDynamic.do")
    @ApiOperation(value = "添加动态",notes = "传手机号，图片链接，")
    public JsonBean addDynamic(@RequestParam("uphone") String uphone,@RequestParam("photo") String photo,@RequestParam("ddesc")String ddesc) {
        return  userService.addDynamic(uphone,photo,ddesc);
    }

    @GetMapping("dynamicList.do")
    @ApiOperation(value = "所有动态",notes = "所有动态")
    public JsonBean dynamicList() {
        return userService.dynamicList();
    }

    @ApiOperation(value = "关注",notes = "传登录人手机号")
    @GetMapping("focus.do")
    public JsonBean focus(@RequestParam("phone1") String phone1, @RequestParam("phone2") String phone2) {
        return userService.focus(phone1,phone2);
    }

    @ApiOperation(value = "屏蔽",notes = "传入被屏蔽人的手机号")
    @GetMapping("keepOut.do")
    public JsonBean keepOut(@RequestParam("phone1") String phone1, @RequestParam("phone2") String phone2) {
       return userService.keepOut(phone1,phone2);
    }

    @ApiOperation(value = "添加评论",notes = "登录人的id以及评论的内容")
    @GetMapping("addComments.do")
    public JsonBean addComments(@RequestParam("id") Integer id, @RequestParam("comments") String comments) {
        return userService.addComments(id,comments);
    }

    @ApiOperation(value = "完善user信息包含图片上传",notes = "传入图片路径，user信息")
    @RequestMapping(value = "addUser.do", method = RequestMethod.POST)
    public JsonBean uploadHead(@RequestParam("file") MultipartFile file,@RequestBody  User user) {
        return userService.uploadHead(file, user);
    }

    //在介绍页中的按条件筛选
    @ApiOperation(value = "按照筛选",notes = "传入输入框中的信息")
    @PostMapping("findCondition.do")
    public JsonBean findCondition(@RequestBody User user) {
       return userService.findCondition(user);
    }

    @ApiOperation(value = "介绍中的根据手机号查询个人信息",notes = "传入要查询人手机号的信息")
    @PostMapping("findByphone.do")
    public JsonBean findByPhone(@RequestParam("phone") String phone){
        return userService.findByPhone(phone);

    }

    @ApiOperation(value = "查看评论",notes = "根据动态的id查询该动态的评论")
    @GetMapping(value = "findcomment.do")
    public JsonBean showComment(@RequestParam("did")int did) {
        return userService.showcomment(did);
    }

    @ApiOperation(value = "根据手机号查动态",notes = "根据手机号查动态")
    @PostMapping("findDynByPhone.do")
    public JsonBean findDynByPhone(@RequestParam("phone") String phone){
        return userService.findDynByPhone(phone);
    }

}
