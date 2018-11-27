package com.mycompany.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.springbootdemo.model.Room;
import com.mycompany.springbootdemo.service.RoomsService;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Value("${spring.data.mongodb.host}")
	private String datFilePath;
	
	
	@Autowired
	private RoomsService roomsService;
	
	@GetMapping("/greeting")
	public String sayHello() {
		return "Hello from controller "+datFilePath;
	}
	
	@GetMapping("/rooms")
	public List<Room> getAllRooms() {
		return roomsService.getAllRooms();
	}
	
	
}
