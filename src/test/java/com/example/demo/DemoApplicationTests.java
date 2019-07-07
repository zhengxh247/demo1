package com.example.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	org.slf4j.Logger logger=LoggerFactory.getLogger(getClass());

	@Test
    public void loadTest() {
		//日志级别由高到低
    	logger.trace("跟踪日志");
    	logger.debug("debug日志");
    	logger.warn("警告日志");
    	logger.error("错误日志");
    }

}
