package com.springdatademo;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springdatademo.dao.CircleDaoImpl;
import com.springdatademo.model.Circle;

@SpringBootApplication
public class SpringDataDemoApplication {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		
		CircleDaoImpl circleDaoImpl = applicationContext.getBean("circleDaoImpl", CircleDaoImpl.class);

		Circle circle = circleDaoImpl.getCircle(100);
		
		System.out.println("Name of the circle: "+circle.getName());
		
		System.out.println("Using JdbcTemplate ------------------");
		System.out.println("Count of circles in database: "+circleDaoImpl.getCircleCount());
		System.out.println("Name of the circle: "+circleDaoImpl.getCircleName(100));
		System.out.println("Circle for id 100: "+ circleDaoImpl.getCircleForId(100).toString());
	}
}
