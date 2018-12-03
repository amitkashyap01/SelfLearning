package com.springaopdemo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springaopdemo.aop.MyAspects;
import com.springaopdemo.service.MyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAopDemoApplicationTests {

	@Autowired
	private MyAspects myAspects;
	
	@Autowired
	private MyService myService;
	
	@Test
	public void checkIfAdviceIsWorking() {
		assertFalse(myAspects.isEnteringCalled());
		
		myService.doSomething();
		
		assertTrue(myAspects.isEnteringCalled());
	}

}
