Aspect = PointCut (Where the aspect is applied) + Advice (What code is executed)

execution(* hello(*)) =  Execution of method hello, "one parameter" of any type,any return type

execution(* hello(..)) = Execution of method hello, any number and any type of parameter, any return type

execution(* com.myapp..*Service.*(..))
	Execution of any method
	class name ends with Service
	in package com.app or subpackage
	any parameter
	any return type
	
execution(* *.*(..))
	Execution of any method with any parameter
	in any class
	"in the default package"
	
execution(* *..*.*(..))
	Execution of any method with any parameter
	in any class
	"in any package or any subpackage of any package"
	

---

Sample AOP architecture

- For each call to service
	- Call must be traced
	- Exceptions must be logged

- For each call to a repository  
	- Call must be traced
	- Performance must be traced
	- Exceptions must be logged
	

Step1: Define architecture using pointcuts
Step2: Define behavior using advices
Step3: Add Advices to correct pointcuts

Tip: Use an annotation for each part of the architecture


---
@Transactional is implemented using Spring AOP.

- Spring AOP uses proxy based AOP
- Either CGLIB(subclasses)
	or Dynamic Proxies (interfaces)

- Local object call will not go through proxy


---------
Spring AOP vs AspectJ

The only difference that Bean pointcut expression will not work with AspectJ as AspectJ is independent of Spring dependencies injection

AspectJ uses Bytecode Weaving i.e. classes and aspect are both "woven" into the bytecode

Weaving might happen
	- When classes are loaded (Load Time Weaving)  - Weaving configured by META-INF/aop.xml
	- When code is compiled

	

