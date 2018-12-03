package com.springaopdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springaopdemo.service.MyService;

@RestController
@RequestMapping("/myapp")
public class MyController {
	
	@Autowired
	private MyService myService;
	
	@GetMapping
	public void myAppMethod() {
		myService.doSomething();
	}
}
