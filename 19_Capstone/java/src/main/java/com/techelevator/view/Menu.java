package com.techelevator.view;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;


public class Menu {

	//private String location;
	private PrintWriter out;
	private Scanner in;
	private Object [] options;
	

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}
	
	public BigDecimal getMoneyFromUser(String message) {
		BigDecimal inputDecimal = null;
		out.println(message);
		do {
			try { 
				String userInput = in.nextLine();
				inputDecimal = new BigDecimal(userInput);
			} catch (NumberFormatException ex) {
				out.print("Please enter a valid number>>> ");
				out.flush();
			}
		} while (inputDecimal == null);
		
		return inputDecimal;
	}

	public void displayMenuOptions(Object[] options) {
		out.println(); 
		//locationInMachine = (String) options[0];
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
		
	}
	}

