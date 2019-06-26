package com.example.demo.redis;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class RedisService {
 
	@Autowired
	JedisPool jedisPool;
	
	
  public <T> T get(String key,Class<T> clazz) {
	  redis.clients.jedis.Jedis jedis=jedisPool.getResource();
	  try {
		jedisPool.getResource();  
		String str=jedis.get(key);
		T t=stringToBean(str,clazz);
		return t;
	  }finally {
		returnToPool(jedis);
	}
  }
  
  private void returnToPool(redis.clients.jedis.Jedis jedis) {
	if(jedis!=null) {
		jedis.close();
	}
	
}
  
  public <T> Boolean set(String key,T value){
	  redis.clients.jedis.Jedis jedis=null;
	  try {
	  jedis=jedisPool.getResource();
	  String string =beanToString(value);
	  jedis.set(key,string);
	  return true;
	  }finally {
		returnToPool(jedis);
	}
  }
  
  private <T> String beanToString(T value) {
	  if(value==null) {
		  return null;
	  }
	  Class<?>clazz=value.getClass();
	  if(clazz==int.class||clazz==Integer.class) {
		  return""+value;
	  }else if(clazz==String.class){
		  return(String)value;
	  }else if(clazz==Long.class){
		  return""+value; 
	  }else {
		  return JSON.toJSONString(value);  
	  }
    }
  
  @SuppressWarnings("unchecked")
private <T>T stringToBean(String str,Class<T> clazz){
	  if(str==null||str.length()<=0||clazz==null) {
		  return null;
	  } 
	  if(clazz==int.class||clazz==Integer.class) {
		  return (T)Integer.valueOf(str);
	  }else if(clazz==String.class){
		  return (T)str;
	  }else if(clazz==Long.class){
		  return (T)Long.valueOf(str); 
	  }else {
		  return JSON.toJavaObject(JSON.parseObject(str), clazz);  
	  }
  }
}
