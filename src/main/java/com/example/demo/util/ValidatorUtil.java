package com.example.demo.util;

import java.util.regex.Pattern;

import com.alibaba.druid.util.StringUtils;


public class ValidatorUtil {
    
	private static final Pattern mabile_pattem=Pattern.compile("1\\d{10}");
	
	public static boolean isMobile(String src) {
		if(StringUtils.isEmpty(src)) {
			return false;
		}
		java.util.regex.Matcher m=mabile_pattem.matcher(src);
		return m.matches();
	}
	
}
