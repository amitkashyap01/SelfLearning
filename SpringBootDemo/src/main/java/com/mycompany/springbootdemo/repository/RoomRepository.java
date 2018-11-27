package com.mycompany.springbootdemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository; 
import org.springframework.stereotype.Repository;

import com.mycompany.springbootdemo.model.Room;

@Repository
public interface RoomRepository extends MongoRepository<Room, Long>{

}
