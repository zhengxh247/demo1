package com.example.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class RedisPoolFactory {

	@Autowired
	RedisConfig redisConfig;
	
	@Bean
	  public JedisPool JedisFactory() {
		 JedisPoolConfig poolConfig=new JedisPoolConfig();
		 poolConfig.setMaxIdle(redisConfig.getMaxIdle());
		 poolConfig.setMaxWaitMillis(redisConfig.getMaxTotal());
		 poolConfig.setMaxWaitMillis(redisConfig.getMaxWait()*1000);
		 JedisPool jp =new JedisPool(poolConfig, redisConfig.getHost(), redisConfig.getPort(), redisConfig.getTimeOut()*1000,redisConfig.getPassword(),0);
	     return jp;
	  }
}
