package com.makingfriends.partner.dao;

import com.makingfriends.entity.Partner;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PartnerDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Partner record);

    int insertSelective(Partner record);

    Partner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Partner record);

    int updateByPrimaryKey(Partner record);

    public Partner findByPid(int id);

}