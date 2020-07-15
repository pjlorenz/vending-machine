package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.techelevator.view.Logger;

public class VendingMachine {
	BigDecimal balance = new BigDecimal(0.00).setScale(2);
	Map<String, List<Item>> inventory = new TreeMap<>();
	List<Item> purchases = new ArrayList();
	Logger writer = new Logger();
	
	public VendingMachine(Map<String, List<Item>> inventory) {
		this.inventory = inventory;
	}

	// machine will display inventory 
	public void displayInventory() {
		for (Map.Entry<String, List<Item>> itemChoice: inventory.entrySet()) {
			String key = itemChoice.getKey();
			List values = itemChoice.getValue();
			if (values.size() == 1) {
				System.out.println("Out of stock");
			}else {
				
			} System.out.println(key + " " + values.subList(0, 1) + " " + (values.size() - 1));
		}
	}
	
	// accept users money and determine balance
	public void feedMoney(int insertMoney) throws FileNotFoundException {
		String transaction = "Feed Money";
		if (insertMoney == 1) {
			balance = balance.add(new BigDecimal(1.00));
			writer.writer(transaction, new BigDecimal(1.00).setScale(2), balance);
		}else if (insertMoney == 2) {
			balance = balance.add(new BigDecimal(2.00));
			writer.writer(transaction, new BigDecimal(2.00).setScale(2), balance);
		}else if (insertMoney == 3) {
			balance = balance.add(new BigDecimal(5.00));
			writer.writer(transaction, new BigDecimal(5.00).setScale(2), balance);
		}else if (insertMoney == 4) {
			balance = balance.add(new BigDecimal(10.00));
			writer.writer(transaction, new BigDecimal(10.00).setScale(2), balance);
		}
		System.out.println("Your balance is now: " + balance);
	} 
	// do actual purchase
	public void Purchase(String userChoice) throws FileNotFoundException {
		if (!inventory.containsKey(userChoice)) {
			System.out.println("That item doesn't exist, choose another item.");
			
		} if (inventory.containsKey(userChoice)) {
			if(inventory.get(userChoice).size() == 0) {
				System.out.println("Sorry, out of stock.");
				
			} if (inventory.get(userChoice).size() >= 1) {
				if (balance.compareTo(inventory.get(userChoice).get(0).getPrice()) >= 0) {
					balance = balance.subtract(inventory.get(userChoice).get(0).getPrice()); 
					Item x = inventory.get(userChoice).remove(0);
					purchases.add(x);
					Item cost = inventory.get(userChoice).get(1);
					BigDecimal cost1 = cost.getPrice();
					Item itemName = inventory.get(userChoice).get(0);
					String item1 = userChoice + " " + itemName.getName(); 
					writer.writer(item1, cost1, balance);
				}
				else {
					System.out.println("Insert more money.");
				}
			}
			System.out.println("Your balance is " + balance);
		}
	}
	
		//complete the transaction
			public void transaction() throws FileNotFoundException {
				Change userChange = new Change();
				userChange.giveChange(balance);
				writer.writer("Dispense change:", balance, new BigDecimal(0.00).setScale(2));				
				while (purchases.size() > 0) {
					Item purchased = purchases.remove(0);
					System.out.println(purchased.getSound());

					System.out.println("Thank you for your purchase!");
//>>>>>>> 35e49130473adfa73a9346cc461c1796d56a980b
				}
			}
	
	
	
	
}
