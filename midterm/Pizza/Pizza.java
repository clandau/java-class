/**
 * Class for a pizza with a size, number of cheese, ham and pepperoni toppings.
 * Class invariant: A Pizza always has a size, default is large. A pizza cannot have more
 * than five of any topping. 
 */
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
		size = size.toLowerCase();
		if (size.equals("small") || size.equals("medium") 
				|| size.equals("large")) {
			this.size = size;
		}
		else {
			System.out.println("Error, incorrect size entry");
			System.exit(0);
		}
		if(validNumber(cheese)) {
			this.cheeseToppings = cheese;
		}
		else {
			System.out.println("Error, incorrect number entry");
			System.exit(0);
		}
		if(validNumber(pepperoni)) {
			this.pepperoniToppings = pepperoni;
		}
		else {
			System.out.println("Error, incorrect number entry");
			System.exit(0);
		}
		if(validNumber(ham)) {
		this.hamToppings = ham;
		}
		else {
			System.out.println("Error, incorrect number entry");
			System.exit(0);
		}
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		size = size.toLowerCase();
		if (size.equals("small") || size.equals("medium") 
				|| size.equals("large")) {
			this.size = size;
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
		if (validNumber(number)) {
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
		if (validNumber(number)) {
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
		if (validNumber(number)){
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
	
	/**
	 * helper function to determine if the number entered is valid, meaning
	 * non-negative and not more than 5.
	 * @param number
	 * @return boolean true if the number entered is greater than zero and less than 5.
	 */
	public boolean validNumber(int number) {
		if (number < 0 || number > 5) return false;
		return true;
	}
}
