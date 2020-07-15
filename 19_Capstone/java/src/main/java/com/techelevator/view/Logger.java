package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class Logger{

	public void writer(String transaction, BigDecimal amount, BigDecimal balance) throws FileNotFoundException {
		
		
		LocalDate currentDay = LocalDate.now();
		LocalTime currentTime = LocalTime.now();
		
		try (PrintWriter logwriter = new PrintWriter(new FileOutputStream(new File("/Users/Student/workspace/week-4-pair-exercises-java-team-6/19_Capstone/java"), true))) {
			
			String printDay = currentDay.toString();
			String printTime = currentTime.toString().substring(0, currentTime.toString().length() - 4);
			String printTransaction = transaction.toString();
			String printAmount = amount.toString();
			String printBalance = balance.toString();
			
			
			logwriter.println(printDay + " " + printTime + " " + String.format("%30s", printTransaction) + String.format("%-15s", "$" + printAmount) + String.format("%-15s", "$" + printBalance));
			
		}catch (FileNotFoundException e) {
			e.getMessage();
		}
				
	}
	
}
