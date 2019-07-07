package com.example.demo.validation;

import com.alibaba.druid.util.StringUtils;
import com.example.demo.util.ValidatorUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class isMobileValidator implements ConstraintValidator<isMobile, String>{

	private boolean required=false;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(required) {
			return ValidatorUtil.isMobile(value);
		}else {
			if(StringUtils.isEmpty(value)) {
				return true;
			}else{
				return ValidatorUtil.isMobile(value);
			}
		}
	}

	@Override
	public void initialize(isMobile constraintAnnotation) {
		required=constraintAnnotation.required();
	}

}
