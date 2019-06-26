package com.example.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.Student;

@Mapper
public interface StudentMapper {
	@Select("select *from student ")
     public Student getAll();
	
	@Insert("insert into student (name,age)values(${name},${age})")
	 public void addAll(Student student);
	
}