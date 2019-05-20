package com.makingfriends.partner.service;

import com.makingfriends.entity.Partner;

/**
 * Created by Administrator on 2019/5/4.
 */
public interface PartnerService {
    int insertSelective(Partner record);

    public Partner findByPid(String phone);

}
