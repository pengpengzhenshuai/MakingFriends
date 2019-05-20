package com.makingfriends.partner.controller;


import com.makingfriends.entity.Partner;
import com.makingfriends.makingcommon.util.JsonBean;
import com.makingfriends.partner.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2019/5/4.
 */
@RestController

public class PartnerController {
    @Autowired
    private PartnerService partnerService;
    //发布自己的目标配偶标准
    @CrossOrigin
    @PostMapping("partner.do")
    public JsonBean addPartener(Partner partner){
        System.out.println(partner);
        partnerService.insertSelective(partner);
        return JsonBean.setOK("添加成功",null);
    }
    //根据pid查询当事人的择偶信息
    @CrossOrigin

    @GetMapping("findByPid.do")
    public JsonBean findPartener(String phone){
        Partner partner = partnerService.findByPid(phone);
        return  JsonBean.setOK("",partner);
    }




}
