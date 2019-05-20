package com.makingfriends.serveruser.service.impl;

import com.makingfriends.makingcommon.util.JsonBean;
import com.makingfriends.serveruser.dao.Userdao;
import com.makingfriends.serveruser.service.UserService;
import com.makingfriends.serveruser.vo.VDynamic;
import com.makingfriends.serveruser.vo.VUser;
import com.makingfriends.entity.Action;
import com.makingfriends.entity.Comments;
import com.makingfriends.entity.Dynamic;
import com.makingfriends.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/4/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Userdao userdao;

    @Override
    public List<User> findPosition() {
        List<User> list = userdao.findPosition();
        return list;
    }

    @Override
    public List<User> findByPosition(String position) {
        List<User> list = userdao.findByPosition(position);
        return list;
    }




    @Override
    public void editInfo(User user) {
        userdao.editInfo(user);
    }

    @Override
    public void findPassword(String phone, String password) {
        if(!userdao.findPassword(phone).equals(password)){

            throw new RuntimeException("原密码不对");
        }


    }


    @Override
    public List<User> findCondition(User user) {
        return userdao.findCondition(user);

    }

    @Override
    public void changePassword(String phone, String newpassword) {
        userdao.changePassword(phone,newpassword);
    }

    @Override
    public List<VUser> focusPerson(String phone) {

        return userdao.focusPerson(phone);
    }

    @Override
    public List<Action> findAction1(String phone) {
        return userdao.findAction1(phone);
    }

    @Override
    public List<Action> findAction2(String phone) {
        return userdao.findAction2(phone);
    }

    @Override
    public void addDynamic(Dynamic dy) {

        userdao.addDynamic(dy);
    }

    @Override
    public List<VDynamic> dynamicList() {
        return userdao.dynamicList();
    }

    @Override
    public void focus(String phone1,String phone2) {



        if(userdao.focus1(phone1,phone2) == null){

            userdao.focus2(phone1,phone2);
        } else {
            userdao.focus3(phone1,phone2);

        }
    }

    @Override
    public void keepOut(String phone1,String phone2) {

        if(userdao.keepOut1(phone1,phone2) == null){

            userdao.keepOut2(phone1,phone2);
        } else {
            userdao.keepOut3(phone1,phone2);

        }
    }


    @Override
    public void addComments(Comments c) {
        userdao.addComments(c);
    }

    @Override
    public User findByPhone(String phone) {
        User user = userdao.findbyphone(phone);
        return user;
    }

    @Override
    public List<Comments> findcomments(int did) {
        List<Comments> list = userdao.findcomments(did);
        return list;
    }

    @Override
    public List<Dynamic> finddecbyphone(String phone) {
        return  userdao.finddecbyphone(phone);
    }

    @Override
    public JsonBean uploadHead(MultipartFile file, User user) {

        try {
            if (file != null) {
                //获取文件名
                String fileName = file.getOriginalFilename();
                //截取扩展名
                String extName = fileName.substring(fileName.lastIndexOf("."));
                List list = new ArrayList();
                list.add(".jpg");
                list.add(".png");
                list.add(".jpeg");
                list.add(".gif");
                if(list.contains(extName.toLowerCase())){
                    String realPath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img";
                    String photoFileName = new Date().getTime()+extName;
                    String descPath = "../img/"+photoFileName;
                    user.setImg("../img/"+photoFileName);
                    System.out.println(user.getImg());
                    System.out.println(user.getName());
                    System.out.println(user.getPhone());

                    /*System.out.println(descPath);*/
                    file.transferTo(new File(realPath,photoFileName));

                    userdao.updateUser(user);
                    return JsonBean.setOK("成功",descPath);//成功
                }else {
                    return JsonBean.setERROR("文件类型不正确",null);//文件类型不正确
                }
            }else {
                return JsonBean.setERROR("上传文件为空",null);//上传文件为空
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonBean.setERROR("上传异常",null);//上传异常
        }
    }

    @Override
    public JsonBean uploadHead(MultipartFile file) {

        try {
            if (file != null) {
                //获取文件名
                String fileName = file.getOriginalFilename();
                //截取扩展名
                String extName = fileName.substring(fileName.lastIndexOf("."));
                List list = new ArrayList();
                list.add(".jpg");
                list.add(".png");
                list.add(".jpeg");
                list.add(".gif");
                if(list.contains(extName.toLowerCase())){

                    //01获取服务器项目部署的路径，并在根目录下创建 myphoto 目录
                    String realPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img";
                    //02也可以直接定义文件路径
                    /*String realPath = "D:\\space\\SSMBase\\src\\main\\webapp\\img";*/

                    String photoFileName = new Date().getTime()+extName;
                    String descPath = "../img/" + photoFileName;

                    /*System.out.println(descPath);*/
                    file.transferTo(new File(realPath,photoFileName));
                   /* map.put("code", 0); // 0 表示成功
                    map.put("msg", descPath);*/
                    System.out.println(realPath);
                    return JsonBean.setOK("上传成功", descPath);
                    /*return map;//成功*/
                }else {

                    return JsonBean.setERROR("上传失败", null);//文件类型不正确
                }
            }else {

                return JsonBean.setERROR("上传失败", null);//上传文件为空
            }
        } catch (Exception e) {
            e.printStackTrace();

            return JsonBean.setERROR("上传失败", null);//上传异常
        }
    }


}
