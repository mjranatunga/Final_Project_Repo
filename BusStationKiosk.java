/**************************************************************
* Name        : Tour Bus Ticket Kiosk 
* Author      : Marissa Ranatunga
* Created     : 4/29/2022
* Course      : CIS 152 Data Structures
* Version     : 1.0
* OS          : Windows 
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program allows the user to purchase tour bus tickets and select the number of tickets they want
*               Input: Desired bus level, and number of desired tickets to purchase
*               Output: The output will show the user a receipt of their purchase 
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/
package busStation;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BusStationKiosk {

	public static final int maxTicketAvailable = 10;
	public static final int value = 10;
	static String name;
	static double amount;
	private static Ticket[] tickets = new Ticket[maxTicketAvailable]; // Keep track of the kiosk inventory
	private static String[] buy = new String[value];
	private static int totalTickets = 0;

	static void printArray(int arr[])

	{

		int n = arr.length;

		for (int i = 0; i < n; ++i)

			System.out.print(arr[i] + " ");

		System.out.println();

	}

	public static void main(String[] args) {

		int arr[] = { 26, 20, 22, 16, 14, 11, 10, 8, 5, 2 };

		System.out.println("All available dates of the month that the busses will be running:");

		printArray(arr);

		DatesOfOperation ob = new DatesOfOperation();

		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nDates shown in order:");

		printArray(arr);

		System.out.println("\n");

// Accepting input
		Scanner keyboard = new Scanner(System.in);
		String input;
		StringTokenizer inputTokenizer;

// Stock up on tickets
		BusStationKiosk inventory = new BusStationKiosk();

		/************************************* bus, price, inventory **/
		inventory.addTickets(new FirstPriceBracketBus("Economy", 8.50, 27));
		inventory.addTickets(new FirstPriceBracketBus("Compact", 11.24, 10));
		inventory.addTickets(new SecondPriceBracketBus("Standard", 14.24, 12));
		inventory.addTickets(new SecondPriceBracketBus("StandardXL", 16.00, 14));
		inventory.addTickets(new ThirdPriceBracketBus("Elite", 18.50, 17));
		inventory.addTickets(new ThirdPriceBracketBus("Luxury", 23.25, 11));

		System.out.println("Available tour bus levels below:");
		System.out.println("");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		inventory.printInventory();
		System.out.println("");

		System.out.println(
				"Enter desired bus level (Example:Compact), and then the number of tickets you would like to buy(Example: 3), followed by hitting ENTER");
		System.out.println("When you are done selecting your tickets please Type \"done\" to finish then hit ENTER");
		System.out.println("");

		double totalPrice = 0;
		double numOfTickets = 0;
// Keep parsing through input
		int j = 0;
		while (!(input = keyboard.nextLine()).equals("done")) {

			inputTokenizer = new StringTokenizer(input);

			name = inputTokenizer.nextToken();
			amount = Double.parseDouble(inputTokenizer.nextToken());
			buy[j] = name + " " + inventory.tickets[j].getPrice() + " " + amount;
// Check if it matches any of the busses available

			for (int i = 0; i < inventory.totalTickets; i++) {

				if (inventory.tickets[i].getName().equals(name)) {

					inventory.tickets[i].decreaseStock(amount);
					totalPrice += amount * inventory.tickets[i].getPrice();
					break;
				}
			}
			numOfTickets++;
			j++;
		}

		System.out.println("Dear Customer your order information is as follow:");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("The total before taxes is $ " + (int) (totalPrice * 100) / 100.0);

		double tax = ((totalPrice) * 0.13);
		double finalCost = totalPrice + tax;

		System.out.println("Tax is $ " + (int) (tax * 100) / 100.0);
		System.out.println("Your total payment is $ " + (int) (finalCost * 100) / 100.0);

// Print results
		System.out.println("\nDo you want to purchase more (y/n) ? ");
		Scanner input1 = new Scanner(System.in);
		String cInput = input1.next();
		char cClub = cInput.charAt(0);

		if (cClub == 'y' || cClub == 'Y') {

			System.out.println("\n");
			System.out.println("Updated Inventory:");
			System.out.println("~~~~~~~~~~~~~~~~~");
			inventory.printInventory();

			System.out.println("\nPlease enter 'y' for a Receipt ? ");
			Scanner input2 = new Scanner(System.in);
			String dInput = input2.next();
			char dClub = dInput.charAt(0);

			if (dClub == 'y' || dClub == 'Y') {
				System.out.println("\n\n");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println(" Bus Station Kiosk\n");
				System.out.println(" RECEIPT");
				System.out.println(" ~~~~~~~~~\n");
				System.out.println("Ticket " + "Ticket Price " + "Amount");
				System.out.println("______________________________________________\n");
				for (int i = 0; i < numOfTickets; i++) {
					System.out.println(buy[i].toString());
				}
				System.out.println("\nTotal number of tickets purchased : " + numOfTickets);
				System.out.println("\nThe subtotal is $ " + (int) (totalPrice * 100) / 100.0);
				System.out.println("Sales Tax $ " + (int) (tax * 100) / 100.0);
				System.out.println("\nFinal price including the Tax $ " + (int) (finalCost * 100) / 100.0);
				System.out.println("\n End of Receipt");
				System.out.println("\nThank you for using the Bus Station Kiosk");
				System.out.println(" Please come back again");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
			input2.close();
		} else {

			System.out.println("Thank you, until next time!");
		}
		keyboard.close();
		input1.close();

	}

	// Add a ticket to the inventory
	public boolean addTickets(Ticket t) {
// List is full
		if (totalTickets >= maxTicketAvailable) {
			return false;
		}

		tickets[totalTickets] = t;
		totalTickets++;

		return true;
	}

	public void printInventory() {
		for (int i = 0; i < totalTickets; i++) {
			System.out.println(tickets[i].toString());
		}
	}

}
