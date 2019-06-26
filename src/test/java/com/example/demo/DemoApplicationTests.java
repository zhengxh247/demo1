package com.example.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.example.demo.model.Student;
import com.example.demo.service.studentService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	org.slf4j.Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
    private studentService studentService;
	@Test
	public void contextLoads() {
	Student student=studentService.showAll();
	 System.out.println(student);
	}
	@Test
    public void loadTest() {
		//日志级别由高到低
    	logger.trace("跟踪日志");
    	logger.debug("debug日志");
    	logger.warn("警告日志");
    	logger.error("错误日志");
    }

}
