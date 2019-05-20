package com.makingfriends.partner.eurekaserver;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "UserProvider")
public interface Userdao {

    @GetMapping("friendidby/phone.do")
    int findIDbyphone(@RequestParam("phone") String phone);
}
