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

public abstract class Ticket {

	private String name; // name of the bus ticket level (ex: Economy, Compact, Luxury, ...)
	private double price; // Price of ticket
	private int stock; // number of tickets the kiosk has in stock

	public Ticket(String name, double price, double stock) {
		this.name = name;
		this.price = price;
		this.stock = (int) stock;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

// Decrease the stock 
// true = success, false = failure
	public boolean decreaseStock(double amount) {
		if (amount <= stock) {
			stock -= amount;
			return true;
		}

		return false;
	}

	public String toString() {
		return name + ", " + "$" + price + ", " + stock + " " + "in stock.";
	}

}
