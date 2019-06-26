package com.example.demo.redis;

public class UserKey extends PrefixImpl{

	private UserKey( String prefix) {
		super( prefix);
	}
    
	public static UserKey getById=new UserKey("id");
	public static UserKey getByName=new UserKey("name");
		
}
