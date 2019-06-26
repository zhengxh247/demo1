package com.example.demo.exception;

import com.example.demo.result.CodeMsg;

public class GlobalExcption extends RuntimeException{
 
	private static final long serialVersionUID=1L;
    private CodeMsg cm;
	public GlobalExcption(CodeMsg cm) {
		super(cm.toString());
		this.cm = cm;
	}
	public CodeMsg getCm() {
		return cm;
	}
	public void setCm(CodeMsg cm) {
		this.cm = cm;
	}
    
    
}
