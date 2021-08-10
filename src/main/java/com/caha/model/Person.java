package com.caha.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Person {
	@Getter @Setter 
	private int id;
	@Getter @Setter
	private String name;
	@Getter @Setter
	private Date expirationDate;
	@Getter @Setter
	private Double cost;
}
