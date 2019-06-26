package com.example.demo.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.example.demo.validation.isMobile;

public class User {
	
	@NotNull
	@isMobile
	private String name;
    
	@NotNull
    @Length(min=32)
	private String password;
	
      public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
