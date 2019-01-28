package com.mycompany.hatesosdemo.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.hatesosdemo.model.Customer;

@RestController
@RequestMapping("/cust")
public class CustomerController {
	
	@GetMapping
	public HttpEntity<Customer> getCustomers() {
		Customer customer = new Customer();
		customer.setCustId("123");
		customer.setCustName("Amti");
		customer.setCustAddress("Captainganj");
		
		Customer customer2 = new Customer();
		customer2.setCustId("456");
		customer2.setCustName("Sonu");
		customer2.setCustAddress("CPJ");
		
		List<Customer> listOfCusts = new ArrayList<>();
		listOfCusts.add(customer);
		listOfCusts.add(customer2);
		
		Link peopleLink = linkTo(CustomerController.class).withSelfRel();
		
		Link selfLink = linkTo(CustomerController.class).slash(customer.getCustId()).withRel("customer");
		
		Link personLink = linkTo(CustomerController.class).slash(customer.getCustName()).withRel("customer");
		
		customer.add(peopleLink);
		customer.add(selfLink);
		customer.add(personLink);
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
}
