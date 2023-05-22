package com.customer.dto;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductDTO {
	
	@JsonIgnore
	private Integer productId;
	private String productname;
	private double productPrice;
	private String createdBy;
	private Date creted;
	private int age;
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreted() {
		return creted;
	}
	public void setCreted(Date creted) {
		this.creted = creted;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	
	

}
