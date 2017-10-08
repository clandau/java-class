
public class Pizza {
	private String size;
	private int cheeseToppings;
	private int pepperoniToppings;
	private int hamToppings;
	
	/**
	 * blank constructor sets a default pizza size as large with one cheese topping
	 */
	public Pizza() {
		size = "large";
		cheeseToppings = 1;
		pepperoniToppings = 0;
		hamToppings = 0;
	}
	
	public Pizza(String size, int cheese, int pepperoni, int ham) {
		this.size = size;
		this.cheeseToppings = cheese;
		this.pepperoniToppings = pepperoni;
		this.hamToppings = ham;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		if (size.toLowerCase() == "small" || size.toLowerCase() == "medium" 
				|| size.toLowerCase() == "large") {
			this.size = size.toLowerCase();
		}
		else {
			System.out.println("Error, incorrect size entry");
			System.exit(0);
		}
	}
	
	public int getCheeseToppings() {
		return cheeseToppings;
	}
	
	public void setCheeseToppings(int number) {
		if (number >= 0) {
			this.cheeseToppings = number;
		}
		else {
			System.out.println("Incorrect number of cheese toppings.");
			System.exit(0);
		}
	}
	
	public int getPepperoniToppings() {
		return pepperoniToppings;
	}
	
	public void setPepperoniToppings(int number) {
		if (number >= 0) {
			this.pepperoniToppings = number;
		}
		else {
			System.out.println("Incorrect number of pepperoni toppings.");
			System.exit(0);
		}
	}
	
	public int getHamToppings() {
		return hamToppings;
	}
	
	public void setHamToppings(int number) {
		if (number >= 0) {
			this.hamToppings = number;
		}
		else {
			System.out.println("Incorrect number of ham toppings.");
			System.exit(0);
		}
	}
	
	/**
	 * method to calculate the cost of the pizza object.
	 * @return returns the total cost of the pizza
	 */
	public int calcCost() {
		int totalCost = 0;
		int toppingCost = 2;
		
		switch(size) {
		case("small"):
			totalCost += 10;
			break;
		case("medium"):
			totalCost += 12;
			break;
		case("large"):
			totalCost += 14;
			break;
		default:
			System.out.println("no size selected.");
			System.exit(0);
		}
		
		return totalCost + (cheeseToppings * toppingCost) + (pepperoniToppings * toppingCost) +
				(hamToppings * toppingCost);		
	}
	
	public String toString() {
		return (size + " pizza with " + cheeseToppings + " cheese topping(s), " + pepperoniToppings +
				" pepperoni topping(s) and " + hamToppings + " ham topping(s).");
	}
	
	public String getDescription() {
		return (size + " pizza with " + cheeseToppings + " cheese topping(s), " + pepperoniToppings +
				" pepperoni topping(s) and " + hamToppings + " ham topping(s).");
	}
	
	/**
	 * Pizza copy constructor
	 */
	public Pizza(Pizza object) {
		this.size = object.size;
		this.cheeseToppings = object.getCheeseToppings();
		this.pepperoniToppings = object.getPepperoniToppings();
		this.hamToppings = object.getHamToppings();
	}
}
