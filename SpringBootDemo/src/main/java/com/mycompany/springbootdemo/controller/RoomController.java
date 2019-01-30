package com.mycompany.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springbootdemo.service.RoomsService;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@Controller
@RequestMapping ("/rooms")
public class RoomController {
	
//	@Autowired
	private RoomsService roomsService;
	
	private final Counter roomCounter;
	
	
	
	/**
	 * @param roomsService
	 * @param roomCounter
	 */
	@Autowired
	public RoomController(RoomsService roomsService, MeterRegistry registry) {
		this.roomsService = roomsService;
		this.roomCounter = Counter.builder("api.roomCounter").register(registry);
	}



	@GetMapping
	@Timed(value="api.getAllRooms")
	public String getAllRooms(Model model) {
		roomCounter.increment();
		
		model.addAttribute("rooms", roomsService.getAllRooms());
		return "rooms";
	}
	
}
