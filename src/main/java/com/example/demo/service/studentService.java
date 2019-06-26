package com.example.demo.service;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentMapper;
import com.example.demo.model.Student;

@Service
public class studentService{
    @Resource
    private StudentMapper mapper;
    /***
     * CacheManager 缓存管理器，管理缓存各个组件
     * CacheName/value:指定缓存名字
     * key:缓存指定
     * key/keyGenerator 二者选一
     * cacheManager 指定缓存管理器；cacheResolver 指定解析器
     * condition 指定符合条件才缓存\
     * unless 否定缓存 ；当指定条件为true，结构不缓存
     * @return
     */
	
    //将方法运行结果进行缓存,以后再要相同数据，直接调用。
    @Cacheable(value="stu")
	public Student showAll() {
		return mapper.getAll();
	}
    
    @CachePut
    public void addAll(Student student) {
    	mapper.addAll(student);
    }
	
    

}
