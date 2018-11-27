package com.mycompany.springbootdemo.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ROOMS")
public class Room {
	private String name;

	private String number;

	private String bedInfo;

	public Room() {}
	/**
	 * @param id
	 * @param name
	 * @param number
	 * @param bedInfo
	 */
	public Room(String name, String number, String bedInfo) {
		super();
		this.name = name;
		this.number = number;
		this.bedInfo = bedInfo;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getBedInfo() {
		return bedInfo;
	}
	public void setBedInfo(String bedInfo) {
		this.bedInfo = bedInfo;
	}
	
	@Override
	public String toString() {
		return "Room [name=" + name + ", number=" + number + ", bedInfo=" + bedInfo + "]";
	}

	
	
}
