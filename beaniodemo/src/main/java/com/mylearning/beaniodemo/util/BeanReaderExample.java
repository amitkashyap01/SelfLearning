package com.mylearning.beaniodemo.util;

import java.io.File;

import org.beanio.BeanReader;
import org.beanio.StreamFactory;

import com.mylearning.beaniodemo.model.Employee;

public class BeanReaderExample {
	public static void main(String[] args) {
		
		StreamFactory streamFactory = StreamFactory.newInstance();
		streamFactory.loadResource("mapping.xml");
		
		BeanReader beanReader = streamFactory.createReader("employeeFile", new File("src/main/resources/data/person.csv"));
		
		Employee employee;
		
		while( (employee = (Employee) beanReader.read()) != null) {
			System.out.println(employee.toString());
			System.out.println(beanReader.getLineNumber());
			
		}

		
		beanReader.close();
		
	}
}
