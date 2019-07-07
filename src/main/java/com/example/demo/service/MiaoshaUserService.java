package com.example.demo.service;

import com.example.demo.dao.MiaoshaUserDao;
import com.example.demo.model.MiaoshaUser;
import com.example.demo.model.User;
import com.example.demo.result.CodeMsg;
import com.example.demo.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiaoshaUserService {
    @Autowired
    MiaoshaUserDao miaoshaUserDao;

   public MiaoshaUser getByMobile(String mobile){
       return miaoshaUserDao.getByMoblie(mobile);
   }

    public CodeMsg login(User user) {
       if(user==null){
           return CodeMsg.SERVER_ERROR;
       }
       String mobile=user.getMobile();
       String formPass=user.getPassword();
       MiaoshaUser MUser=getByMobile(mobile);
       if (MUser==null){
           return CodeMsg.MOBILE_NOT_EXIT;
           }
       String dbPass=MUser.getPassword();
       String saltDB=MUser.getSalt();
       String calcPass= MD5Util.formPasstoDBPass(formPass,saltDB);
       if(calcPass.equals(dbPass)){
           return  CodeMsg.SUCCESS;
       }else {
           return CodeMsg.PASSWORD_ERROR;
       }

    }
}
