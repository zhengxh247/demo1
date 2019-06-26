package com.example.demo.result;

public class CodeMsg {

	private int code;
	private String msg;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	// 通用错误码
	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务器端异常");
	public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常:%s");

	// 登录模块 5002xx
	public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "SESSION不存在或已经失效");
	public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
	public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号码不能为空");
	public static CodeMsg MOBLIE_ERROR = new CodeMsg(500213, "手机号码格式错误");
	public static CodeMsg MOBILE_NOT_EXIT = new CodeMsg(500214, "手机号码不存在");
	
	private CodeMsg(int code,String msg) {
		this.code=code;
		this.msg=msg;
	}
	
    public CodeMsg filArgs(Object... args) {
    	int code =this.code;
    	String message=String.format(this.msg,args);
        return new CodeMsg(code, message);
    }
}
