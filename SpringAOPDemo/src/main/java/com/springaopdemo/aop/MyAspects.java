package com.springaopdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspects {
	
	boolean enteringCalled = false;
	
	public boolean isEnteringCalled() {
		return enteringCalled;
	}
	Logger LOGGER = LoggerFactory.getLogger(MyAspects.class);
	
	@Before("execution(* com.springaopdemo..*.*(..))") // for matching any method with any return type and any parameter, in com.springaopdemo and its subpackage
	public void myFirstAspect(JoinPoint joinpoint) {
		enteringCalled = true;
		LOGGER.info("Entering into "+joinpoint.getStaticPart().getSignature().toString());
		
	}
	
	@Before("com.springaopdemo.pointcuts.MyPointcuts.myPointCutMethod()") // Using pointcut defined in MyPointcuts class
	public void myServiceAspectForBefore(JoinPoint joinPoint) {
		LOGGER.info("Entering into service: "+joinPoint.getSignature().toString());
		
	}
	
	@Around("com.springaopdemo.pointcuts.MyPointcuts.whileCallingController()") // Using pointcut defined in MyPointcuts class
	public void myServiceAspectForArounde(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		LOGGER.info("Entering into controller: "+proceedingJoinPoint.getSignature().toString());
		
		try {
			proceedingJoinPoint.proceed();
			LOGGER.info("Called the method: "+proceedingJoinPoint.getSignature().toString());
			
		} catch (Throwable e) {
			// TODO: handle exception
			LOGGER.error("Execption Occured: "+e.toString());
			throw e;
		}
		
		LOGGER.info("Exiting from controller: "+proceedingJoinPoint.getSignature().toString());
		
	}
	
	@After("execution(void doSomething())")
	public void myAfterAspect(JoinPoint joinpoint) {
		enteringCalled = true;
		LOGGER.info("Exiting from "+joinpoint.getStaticPart().getSignature().toString());
		
		for(Object arg: joinpoint.getArgs()) {
			LOGGER.info("Arg: "+arg);
		}
		
	}
	
	
	@AfterThrowing(pointcut = "execution(void doSomething())")
	public void myAfterThrowingAdvice() {
		enteringCalled = true;
		LOGGER.error("Error Occured");
	}
	
	
	//Below advice executed only when the exception is of type RuntimeException
	@AfterThrowing(pointcut = "execution(void doSomething())",
			throwing="rte")
	public void myAfterThrowingRunTimeExceptionAdvice(RuntimeException rte) {
		enteringCalled = true;
		LOGGER.error("Exception Occured: "+rte);
	}
	
	//Below method is excuted only when the return type is String
	
	@AfterReturning(pointcut="execution(String doSomething())", returning="myString")
	public void myAfterReturningAdvice(String myString) {
		
		LOGGER.info(" Returning "+myString);
	}
}
