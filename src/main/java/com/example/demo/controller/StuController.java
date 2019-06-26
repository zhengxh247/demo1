package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.example.demo.model.User;
import com.example.demo.result.CodeMsg;
import com.example.demo.result.Result;
import com.example.demo.util.ValidatorUtil;



@Controller
@RequestMapping("/demo")
public class StuController {
	
	@RequestMapping("/toLogin")
    public String toLogin() {
		return "Login";
	}
	
	@RequestMapping("/doLogin")
	@ResponseBody
	public Result<Boolean> error(){
		return Result.error(CodeMsg.SESSION_ERROR);
	}
	
	@RequestMapping("/do_Login")
	@ResponseBody
	public Result<Boolean> ddLogin(User user){
		String password=user.getPassword();
		String mobile=user.getName();
		if (StringUtils.isEmpty(password)) {
			return Result.error(CodeMsg.PASSWORD_EMPTY);
		}
		if (StringUtils.isEmpty(mobile)) {
			return Result.error(CodeMsg.MOBILE_EMPTY);
		}
		if (!ValidatorUtil.isMobile(mobile)) {
			return Result.error(CodeMsg.MOBLIE_ERROR);
		}
		return null;
	}
	
}
