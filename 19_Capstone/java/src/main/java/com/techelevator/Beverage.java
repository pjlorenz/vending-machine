package com.techelevator;

import java.math.BigDecimal;

public class Beverage extends Item {

	public Beverage(String name, BigDecimal price) {
		super(name, price);
	}
	
	public String getSound() {
		return "Glug Glug, Yum!";
	}
}
