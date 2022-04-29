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

public class SecondPriceBracketBus extends Ticket {

	public SecondPriceBracketBus(String name, double price, double stock) {
		super(name, price, stock);
	}

	public String toString() {
		return " Bus(s) in Second Price Bracket: " + super.toString();
	}
}