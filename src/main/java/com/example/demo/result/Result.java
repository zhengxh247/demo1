package com.example.demo.result;

public class Result<T> {
	private int code;
	private T data;
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 成功时候调用
	 */
	public static <T> Result<T> seccess(T data) {
		return new Result<T>(data);
	}
	
	private Result(T data) {
		this.code=0;
		this.msg="success";
		this.data=data;
	}

	private Result(CodeMsg cm) {
		if(cm==null) {
			return ;
		}
		this.code=cm.getCode();
		this.msg=cm.getMsg();
	}

	/**
	 * 失败时候调用
	 */
	public static <T> Result<T> error(CodeMsg cm) {
		return new Result<T>(cm);
	}
}