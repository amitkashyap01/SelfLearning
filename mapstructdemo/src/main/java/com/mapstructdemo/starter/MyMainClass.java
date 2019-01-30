package com.mapstructdemo.starter;

import org.mapstruct.factory.Mappers;

import com.mapstructdemo.mappers.CustomerMapper;
import com.mapstructdemo.model.Customer;
import com.mapstructdemo.model.CustomerDto;

public class MyMainClass {
	public static void main(String args[]) {
		Customer customer = new Customer();
		customer.setFirstName("Amit");
		customer.setSecondName("Kashyap");
		customer.setAge(32);
		customer.setCategory("Indian");
		
		
		CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);
		
		CustomerDto custDto = customerMapper.customerToCustomerDto(customer);
		
		System.out.println(custDto.toString());
		
	}
}
