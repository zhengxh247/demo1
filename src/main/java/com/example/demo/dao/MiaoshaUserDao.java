package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.MiaoshaUser;

public interface MiaoshaUserDao {
	@Select("select * from miaosha_user where id=#{id}")
    public MiaoshaUser getById(@Param("id") Long id); 
}
