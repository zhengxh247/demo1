package com.example.demo.redis;

public abstract class BasePrefix implements KeyPrefix{

    private int expireSeconds;
    private  String prefix;

    public BasePrefix(int expireSeconds,String prefix){
        this.expireSeconds=expireSeconds;
        this.prefix=prefix;
    }

    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
