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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bedInfo == null) ? 0 : bedInfo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (bedInfo == null) {
			if (other.bedInfo != null)
				return false;
		} else if (!bedInfo.equals(other.bedInfo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}



}
