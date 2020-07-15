package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.techelevator.Beverage;
import com.techelevator.Candy;
import com.techelevator.Chips;
import com.techelevator.Gum;
import com.techelevator.Item;

public class FileReader {
	
	public Map<String, List<Item>> fileImporter() {

		File itemInventory = new File("/Users/Student/workspace/week-4-pair-exercises-java-team-6/19_Capstone/java/VendingMachine.txt"); //VendingMachine.txt
 
		Map<String, List<Item>> machineInventory = new TreeMap<>();
		
		try (Scanner fileReader = new Scanner(itemInventory)) {
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				if(!line.isEmpty()) {
					String [] inventoryArray = line.split("\\|");
					
					if (inventoryArray[0].contains("A")) {
						List<Item> itemArray = new ArrayList<>();
						for (int i = 0; i < 6; i++) {
							Chips productChips = new Chips(inventoryArray[1], new BigDecimal(inventoryArray[2]));
							itemArray.add(productChips);
							
						}
						machineInventory.put(inventoryArray[0], itemArray);
						
					} else if (inventoryArray[0].contains("B")) {
						List<Item> itemArray = new ArrayList<>();
						for (int i = 0; i < 6; i++) {
							Candy productCandy = new Candy(inventoryArray[1], new BigDecimal(inventoryArray[2]));
							itemArray.add(productCandy);
							
						}
						machineInventory.put(inventoryArray[0], itemArray);
						
					} else if (inventoryArray[0].contains("C")) {
						List<Item> itemArray = new ArrayList<>();
						for (int i = 0; i < 6; i++) {
							Beverage productBeverage = new Beverage(inventoryArray[1], new BigDecimal(inventoryArray[2]));
							itemArray.add(productBeverage);
							
						}
						machineInventory.put(inventoryArray[0], itemArray);
						
					} else if (inventoryArray[0].contains("D")) {
						List<Item> itemArray = new ArrayList<>();
						for (int i = 0; i < 6; i++) {
							Gum productGum = new Gum(inventoryArray[1],new BigDecimal(inventoryArray[2]));
							itemArray.add(productGum);
							
						}
						machineInventory.put(inventoryArray[0], itemArray);
						
					}
				}
			} return machineInventory;
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist.");
			System.exit(1);
			return machineInventory;
		} 
	}
}

	
