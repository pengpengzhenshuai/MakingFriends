package com.makingfriends.api.api.Partner;

import com.makingfriends.api.service.LoginService;
import com.makingfriends.api.service.PartnerService;
import com.makingfriends.entity.Partner;
import com.makingfriends.makingcommon.util.JsonBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "配偶要求相关操作",tags = "配偶相关")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @PostMapping("partner.do")
    @ApiOperation(value = "发布自己的目标配偶标准",notes = "传入配偶对象")
    public JsonBean addPartener(@RequestParam("partner") Partner partner){
        return partnerService.addPartener(partner);
    }
    @GetMapping("findByPid.do")
    @ApiOperation(value = "根据查看那个人传她的id查询配偶信息",notes = "根据被查看人的id查询配偶要求")
    public  JsonBean findPartener(@RequestParam("phone") String phone) {
        return partnerService.findPartener(phone);
    }
}
