package com.caha.model;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class Product {
	private int id;
	@ApiModelProperty(notes = "Name of the Product",name="name",required=true,value="test name")
	private String name;
	@ApiModelProperty(notes = "Expiration date",name="expirationDate",required=true,value="08/09/2021")
	private Date expirationDate;
	@ApiModelProperty(notes = "Product cost",name="cost",required=true,value="12.18")
	private Double cost;
	
	public Product() {
		
	}
	
	public Product(int id, String name, Date expirationDate, Double cost) {
		super();
		this.id = id;
		this.name = name;
		this.expirationDate = expirationDate;
		this.cost = cost;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
}
