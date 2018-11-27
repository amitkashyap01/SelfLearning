package com.mycompany.springbootdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.springbootdemo.model.Room;
import com.mycompany.springbootdemo.repository.RoomRepository;

@Service
public class RoomsService {
	
	public RoomRepository repository;
	
	@Autowired
	public RoomsService(RoomRepository repository) {
		super();
		this.repository=repository;
	}
	
	public List<Room> getAllRooms(){
		List<Room> rooms = new ArrayList<>();
		this.repository.findAll().forEach(rooms::add);
		return rooms;

	}
}
