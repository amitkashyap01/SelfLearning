package com.mycompany.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springbootdemo.service.RoomsService;

@Controller
@RequestMapping ("/rooms")
public class RoomController {
	
	@Autowired
	private RoomsService roomsService;
	
	@GetMapping
	public String getAllRooms(Model model) {
		model.addAttribute("rooms", roomsService.getAllRooms());
		return "rooms";
	}
	
}
