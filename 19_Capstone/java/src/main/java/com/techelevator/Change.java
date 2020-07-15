package com.techelevator;

import java.math.BigDecimal;

public class Change {
	
			private BigDecimal changeDue;
	
	public void giveChange(BigDecimal balance) {
		
		changeDue = balance;
		
		
		System.out.println("Your change is $" + changeDue);
	}
		
}
