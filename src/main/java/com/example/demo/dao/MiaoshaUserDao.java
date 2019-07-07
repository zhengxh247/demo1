package com.example.demo.dao;

import com.example.demo.model.MiaoshaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MiaoshaUserDao {
    @Select("select * from miaosha_user where mobile=#{mobile}")
    public MiaoshaUser getByMoblie(@Param("mobile") String mobile);
}
