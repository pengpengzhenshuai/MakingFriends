package com.makingfriends.api.service;

import com.makingfriends.entity.Partner;
import com.makingfriends.makingcommon.util.JsonBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "partnerProvider")
public interface PartnerService {

    @PostMapping("partner.do")
    JsonBean addPartener(Partner partner);

    @GetMapping("findByPid.do")
    JsonBean findPartener(String phone);


}
