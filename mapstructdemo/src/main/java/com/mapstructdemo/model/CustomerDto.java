package com.mapstructdemo.model;

import java.util.Date;

public class CustomerDto {
	private String name;
	private String category;
	private Date dob;
	private int age;
	private AddressDto address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "CustomerDto [name=" + name + ", category=" + category + ", dob=" + dob + ", age=" + age + ", address="
				+ address + "]";
	}
	
	
}
