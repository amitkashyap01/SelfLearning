package com.springlearn.springMVCDemo.controllers;

import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springlearn.springMVCDemo.model.Account;

@Controller
@SessionAttributes("aNewAccount")
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
	
	//This is the first method to be executed/
	@ModelAttribute
	//public void setUserDetails(@RequestParam("userName") String username, Model model) {
	public void setUserDetails(Model model) {
		//model.addAttribute("userName", username);
		
		if(!model.containsAttribute("aNewAccount")) {
			Account account = new Account();
			model.addAttribute("aNewAccount", account);
		}
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
	

	
	@RequestMapping(value="/doCreate")
	public String doCreate(@ModelAttribute("aNewAccount") Account account, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("Form Not Valid");
			return "createAccount";
		}
	
		System.out.println("Form Validated");
		
		System.out.println("Got Acount: "+account.toString());
		return "redirect:acctConfirm.html";
	}
	
	@RequestMapping(value="/acctConfirm")
	public String acctConfirm(@ModelAttribute("aNewAccount") Account account) {
		
		System.out.println("Welcome "+account.getFirstName());
		
		return "AccountConfirmation";
	}

	
	@RequestMapping("/addCookie")
	public String addCookie(HttpServletResponse response) {
		response.addCookie(new Cookie("myNewCookie", "TheCookieValue"));
		return "Quote";
	}
	
	@RequestMapping("/getCookie")
	public String getCookie(@CookieValue("myNewCookie") String myCookies) {
		System.out.println( "Here is my cookie: "+myCookies);
		
		return "Quote";
	}
}
