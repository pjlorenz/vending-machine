package com.techelevator;
import com.techelevator.view.FileReader;
import com.techelevator.VendingMachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import com.techelevator.Candy;
import com.techelevator.Chips;
import com.techelevator.Beverage;
import com.techelevator.Gum;


import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	private static final String SUB_MENU_OPTION_FEED_MONEY = "Feed money";
	private static final String SUB_MENU_OPTION_PURCHASE = "Select An Item";
	private static final String SUB_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] SUB_MENU_OPTIONS = { SUB_MENU_OPTION_FEED_MONEY, SUB_MENU_OPTION_PURCHASE,SUB_MENU_OPTION_FINISH_TRANSACTION };
	private static final String MONEY_MENU_OPTION_ONE_DOLLAR = "Insert 1 dollar";
	private static final String MONEY_MENU_OPTION_TWO_DOLLAR = "Insert 2 dollars";
	private static final String MONEY_MENU_OPTION_FIVE_DOLLAR = "Insert 5 dollars";
	private static final String MONEY_MENU_OPTION_TEN_DOLLAR = "Insert 10 dollars";
	private static final String[] MONEY_MENU_OPTIONS = { MONEY_MENU_OPTION_ONE_DOLLAR, MONEY_MENU_OPTION_TWO_DOLLAR,MONEY_MENU_OPTION_FIVE_DOLLAR, MONEY_MENU_OPTION_TEN_DOLLAR };
	
	
	private static final char[] FileReader = null;
	//private VendingMachine machine = null;
	private Menu menu; 
//<<<<<<< HEAD
	//private Inventory inventory; // initiating variable to hold future object
	File itemInventory = new File("/Users/Student/workspace/week-4-pair-exercises-java-team-6/19_Capstone/java/VendingMachine.txt"); //VendingMachine.txt
//=======
	private static VendingMachine vm = null;
	//private Inventory inventory; // initiating varialb to hold future object
	//File itemInventory = new File("/Users/Student/workspace/week-4-pair-exercises-java-team-6/19_Capstone/java/VendingMachine.txt"); //VendingMachine.txt
//>>>>>>> 35e49130473adfa73a9346cc461c1796d56a980b
	 

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
//<<<<<<< HEAD
				try {
					FileReader fileReader = new FileReader(itemInventory);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//=======
				vm.displayInventory();
//>>>>>>> 35e49130473adfa73a9346cc461c1796d56a980b
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				while (true) {
					String submenuChoice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
					if (submenuChoice.equals(SUB_MENU_OPTION_FEED_MONEY)) {
						String moneyChoice = (String) menu.getChoiceFromOptions(MONEY_MENU_OPTIONS);
						
						if (moneyChoice.equals(MONEY_MENU_OPTION_ONE_DOLLAR)) {
							vm.feedMoney(1);
						} else if (moneyChoice.equals(MONEY_MENU_OPTION_TWO_DOLLAR)) {
							vm.feedMoney(2);
						} else if (moneyChoice.equals(MONEY_MENU_OPTION_FIVE_DOLLAR)) {
							vm.feedMoney(3);
						} else if (moneyChoice.equals(MONEY_MENU_OPTION_TEN_DOLLAR)) {
							vm.feedMoney(4);
						}
					} else if (submenuChoice.equals(SUB_MENU_OPTION_PURCHASE)) {
						vm.displayInventory();
						System.out.println("Enter your selection: ");
						Scanner selected = new Scanner(System.in);
						String userSelection = selected.nextLine();
						vm.Purchase(userSelection);
					} else if (submenuChoice.equals(SUB_MENU_OPTION_FINISH_TRANSACTION)) {
						vm.transaction();
						break;
					}
			}
		}
	}
}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		vm = new VendingMachine(new FileReader().fileImporter());
		cli.run();
	}
}
