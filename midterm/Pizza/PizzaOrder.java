/**
 * Class for an order of 1-3 pizzas with a number, and up to three Pizzas. 
 * Class invariant: A PizzaOrder always has a number of pizzas and it must
 * be between 1 and 3, although they may all be null. 
 * A default order may be created with 1 default Pizza order attached. 
 */
public class PizzaOrder {
	private int numberOfPizzas;
	private Pizza pizzaOne, pizzaTwo, pizzaThree;
	
	/**
	 * no argument constructor creates a pizza order with one 
	 * large cheese pizza
	 */
	public PizzaOrder() {
		numberOfPizzas = 1;
		pizzaOne = new Pizza();
	}
	
	/**
	 * constructors that allow the creation of a pizza order directly
	 * with 1, 2 or 3 pizzas
	 * @param 1, 2, or 3 pizza objects
	 */
	public PizzaOrder(Pizza one) {
		numberOfPizzas = 1;
		pizzaOne = new Pizza(one);
	}
	
	public PizzaOrder(Pizza one, Pizza two) {
		numberOfPizzas = 2;
		pizzaOne = new Pizza(one);
		pizzaTwo = new Pizza(two);
	}
	
	public PizzaOrder(Pizza one, Pizza two, Pizza three) {
		numberOfPizzas = 3;
		pizzaOne = new Pizza(one);
		pizzaTwo = new Pizza(two);
		pizzaThree = new Pizza(three);
	}
	
	/**
	 * method to set the number of pizzas in the order
	 * @param number of pizzas
	 */
	public void setPizzaNumber(int number) {
		if (numberOk(number)) {
			numberOfPizzas = number;
		}
		else {
			System.out.println("Incorrect entry. Enter between 1 and 3 pizzas for an order.");
			System.exit(0);
		}
	}
	
	public int getPizzaNumber() {
		return numberOfPizzas;
	}
	
	public void setPizzaOne(Pizza pizza) {
		if (numberOfPizzas >= 1) {
			pizzaOne = new Pizza(pizza);
		}
		else {
			System.out.println("Cannot add another pizza to this order before increasing the size of the order.");
		}
	}
	
	public Pizza getPizzaOne() {
		if(pizzaOne != null) {
			return pizzaOne;
		}
		else return null;
	}
	
	public void setPizzaTwo(Pizza pizza) {
		if (numberOfPizzas >= 2) {
			pizzaTwo = new Pizza(pizza);
		}
		else {
			System.out.println("Cannot add another pizza to this order before increasing the size of the order.");
		}
	}
	
	public Pizza getPizzaTwo() {
		if(pizzaTwo != null) {
			return pizzaTwo;
		}
		else return null;
	}
	
	public void setPizzaThree(Pizza pizza) {
		if (numberOfPizzas == 3) {
			pizzaThree = new Pizza(pizza);
		}
		else {
			System.out.println("Cannot add another pizza to this order before increasing the size of the order.");
		}
	}
	
	public Pizza getPizzaThree() {
		if(pizzaThree != null) {
			return pizzaThree;
		}
		else return null;
	}
	
	public String toString() {
		String returnString = "This order contains:\n";
		if (pizzaOne != null) {
			returnString += (pizzaOne + "\n"); 
		}
		if (pizzaTwo != null) {
			returnString += (pizzaTwo + "\n");
		}
		if(pizzaThree != null) {
			returnString += (pizzaThree + "\n");
		}
		return returnString;
	}
	
	/**
	 * copy constructor
	 * @param a PizzaOrder to duplicate
	 */
	public PizzaOrder(PizzaOrder original) {
		if (original != null) {
			this.numberOfPizzas = original.numberOfPizzas;
			if (original.pizzaOne != null) {
				this.pizzaOne = new Pizza(original.pizzaOne.getSize(), original.pizzaOne.getCheeseToppings(), 
						original.pizzaOne.getPepperoniToppings(), original.pizzaOne.getHamToppings());
			}
			if(original.pizzaTwo != null) {
				this.pizzaTwo = new Pizza(original.pizzaTwo.getSize(), original.pizzaTwo.getCheeseToppings(), 
						original.pizzaTwo.getPepperoniToppings(), original.pizzaTwo.getHamToppings());
			}
			if(original.pizzaThree != null) {
				this.pizzaTwo = new Pizza(original.pizzaThree.getSize(), original.pizzaThree.getCheeseToppings(), 
						original.pizzaThree.getPepperoniToppings(), original.pizzaThree.getHamToppings());
			}
		}
		else {
			System.out.println("Original is null.");
			System.exit(0);
		}
	}
	
	/**
	 * helper method to verify that the number of pizzas 
	 * specified is between 1 and 3. 
	 * @param number input by user to represent number of pizzas 
	 * to add to order.
	 * @return boolean true if number is between 1 and 3
	 */
	public boolean numberOk(int number) {
		return (number >= 1 || number <= 3);
	}
	
	/**
	 * method to return the total cost of the order. 
	 * uses the calcCost method from the Pizza class.
	 * @return an integer representing the total cost
	 */
	
	public int totalCost() {
		int totalCost = 0;
		if (pizzaOne != null) {
			totalCost += pizzaOne.calcCost(); 
		}
		if (pizzaTwo != null) {
			totalCost += pizzaTwo.calcCost(); 
		}
		if(pizzaThree != null) {
			totalCost += pizzaThree.calcCost(); 
		}
		return totalCost;
	}
}
