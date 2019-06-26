package com.example.demo.exception;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import com.example.demo.result.CodeMsg;
import com.example.demo.result.Result;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandle {
      
	@ExceptionHandler(value=Exception.class)
	public Result<String> excepionHandler(HttpServletRequest request,Exception e) {
		if(e instanceof GlobalExcption) {
		GlobalExcption ex=(GlobalExcption)e;	
		return Result.error(ex.getCm());
		}else if(e instanceof BindException) {
		BindException ex=(BindException)e;
		List<ObjectError>errors=ex.getAllErrors();
		ObjectError error=errors.get(0);
		String msg=error.getDefaultMessage();
		return Result.error(CodeMsg.BIND_ERROR.filArgs(msg));
		}else {
			return Result.error(CodeMsg.SERVER_ERROR);
		}
	}
	
}
