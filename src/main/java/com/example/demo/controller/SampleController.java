package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.redis.RedisService;
import com.example.demo.model.Student;

@Controller
@RequestMapping("/demo")
public class SampleController {
   @Autowired
   RedisService redisService;
   
   @RequestMapping("/redis/get")
   @ResponseBody
   public Student redisGet(){
   redisService.get("key1",Long.class);
return null;

   }
   
}
