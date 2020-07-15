package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item {

	public Candy(String name, BigDecimal price) {
		super(name, price);
	}
	
	public String getSound() {
		return "Munch Munch, Yum!";
	}
	
	
}
