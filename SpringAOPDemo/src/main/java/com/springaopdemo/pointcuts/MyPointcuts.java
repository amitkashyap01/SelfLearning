package com.springaopdemo.pointcuts;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {

	@Pointcut("execution(* com.springaopdemo.service..*.*(..))")
	public void myPointCutMethod() {
		
	}
	
	@Pointcut("execution(* com.springaopdemo.controller..*.*(..))")
	public void whileCallingController() {
		
	}
	
	// Can be used for specific bean
	@Pointcut("bean(*Service))")
	public void whileCallingBean() {
		
	}
	
	// || and && can be used
	@Pointcut("execution(* com.springaop.demo.*.*Service(..)) || execution(* com.springaop.demo.*.*Controller(..))")
	public void something() {
		
	}
}
