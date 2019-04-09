package com.mylearning.beaniodemo.util;

import java.io.File;
import java.util.Date;

import org.beanio.BeanWriter;
import org.beanio.StreamFactory;

import com.mylearning.beaniodemo.model.Employee;

public class BeanWriterExample {
	public static void main(String args[]) {
		
		StreamFactory factory = StreamFactory.newInstance();
		factory.loadResource("mapping.xml");
		
		
		Employee emp1 = new Employee();
		emp1.setFirstName("Amit");
		emp1.setLastName("Kashyap");
		emp1.setTitle("IT");
		emp1.setSalary(22222);
		emp1.setHireDate(new Date());
		
		/**
		 * Employee emp1 = null;
		
		for(int i=0; i<100; i++) {
			emp1 = new Employee();
			
			emp1.setFirstName("Amit");
			emp1.setLastName("Kashyap");
			emp1.setTitle("IT");
			emp1.setSalary(22222);
			emp1.setHireDate(new Date());
			listOfEmployees.add(emp1);
		}
		
		 * 
		 * */
		
		BeanWriter beanWriter = factory.createWriter("employeeFile", new File("src/main/resources/data/newperson.csv"));
		
		beanWriter.write(emp1);
		beanWriter.flush();
		beanWriter.close();
		
	}
}
