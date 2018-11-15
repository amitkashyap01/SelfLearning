package com.springlearn.springMVCDemo.controllers;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlearn.springMVCDemo.model.Account;

@Controller
public class MyDemoController {
	
	String[] quotes = {
			"To be or not to be - Shakespeare",
			"Do or die - Amit"
	};
	
	@RequestMapping(value = "/getQuote")
	public String getQuote(Model model) {
		int quoteLength = quotes.length;
		
		int randNumber = new Random().nextInt(quoteLength);
		
		String randomQuote = quotes[randNumber];
		
		model.addAttribute("randomQuote", randomQuote);
		
		return "Quote";
	}
	
	
	@RequestMapping(value="/createAccount")
	public String createAccount(@Valid @ModelAttribute("aNewAccount") Account account, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("Form Not Valid");
			return "createAccount";
		}
	
		System.out.println("Form Validated");
		
		System.out.println("Got Acount: "+account.toString());
		return "createAccount";
	}
}
