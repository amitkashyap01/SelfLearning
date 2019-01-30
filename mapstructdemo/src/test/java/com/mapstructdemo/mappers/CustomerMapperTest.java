package com.mapstructdemo.mappers;

import org.junit.Assert;
import org.junit.Test;

import com.mapstructdemo.model.Customer;
import com.mapstructdemo.model.CustomerDto;

public class CustomerMapperTest {
	
	@Test
	public void testingCustomerToCustomerDto() {
		Customer customer = new Customer();
		customer.setFirstName("Amit");
		customer.setSecondName("Kashyap");
		customer.setAge(32);
		customer.setCategory("Indian");
		
		CustomerDto customerDto = CustomerMapper.INSTANCE.customerToCustomerDto(customer);
	
		Assert.assertEquals(customer.getSecondName(), customerDto.getName());
	}
}
