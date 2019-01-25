package com.jaxb.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Product {
	private int productid;
	private String productName;
	private String productDescription;
	private LocalDate boughtDate;
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public LocalDate getBoughtDate() {
		return boughtDate;
	}
	public void setBoughtDate(LocalDate boughtDate) {
		this.boughtDate = boughtDate;
	}
	
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productName=" + productName + ", productDescription="
				+ productDescription + ", boughtDate=" + boughtDate + "]";
	}

}
