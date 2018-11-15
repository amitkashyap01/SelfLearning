package com.springlearn.springMVCDemo.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyDemoController {
	
	String[] quotes = {
			"To be or not to be - Shakespeare",
			"Do or die - Amit"
	};
	
	@RequestMapping(value = "/getQuote")
	public String getQuote(Model model) {
		
		Random randNumber = new Random().nextInt(quotes.length);
		String randomQuote = quotes[randNumber];
		
		model.addAttribute("randomQuote", randomQuote);
		
		return "Quote";
	}

}
