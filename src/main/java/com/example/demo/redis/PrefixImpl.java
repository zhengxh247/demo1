package com.example.demo.redis;

public abstract class PrefixImpl implements KeyPrefix{
    
	private int expireSeconds;
	private String prefix;
	
	public PrefixImpl(String prefix) {//0代表永不过期
		this(0, prefix);
		}
	
	public PrefixImpl(int expireSeconds,String prefix) {
		this.expireSeconds=expireSeconds;
		this.prefix=prefix;
	}

	public int expireSeconds() {
		// TODO Auto-generated method stub
		return expireSeconds;
	}

	public String getPrefix() {
	  String className=getClass().getSimpleName();
		return className+":"+prefix;
	}

}
