package com.mycompany.springbootdemo.configuration;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.springbootdemo.model.Room;
import com.mycompany.springbootdemo.repository.RoomRepository;

@Component
public class MyCommandRuuner implements CommandLineRunner{

	@Autowired
	private RoomRepository roomRepository;
	
	@Override
	public void run(String... args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println("Inside CommandLineRunner");
		//read json file data to String
		List<Room> listOfRooms = mapper.readValue(new File("src/main/resources/data.json"), new TypeReference<List<Room>>(){});
		
		System.out.println("List of Rooms: "+listOfRooms);
		
		roomRepository.deleteAll();
		
		for (Room room : listOfRooms) {
			roomRepository.save(room);
			System.out.println("Loading: "+room);
		}
		
	}

}
