package busStation;

public class ThirdPriceBracketBus extends Ticket {

	public ThirdPriceBracketBus(String name, double price, double stock) {
		super(name, price, stock);
	}

	public String toString() {
		return " Bus(s) in Third Price Bracket: " + super.toString();
	}

}