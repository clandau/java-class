/**
 * Main program to test Pizza and PizzaOrder classes.
 * 
 * @author Courtney Landau
 */
public class PizzaAndOrderDemo {

	public static void main(String[] args) {
		
		/**
		 * The following code creates 2 pizza objects, and changes some of the toppings
		 * using set methods. It then creates a PizzaOrder object using the 2 Pizza argument
		 * constructor.  It then  prints the order to the console and prints the total
		 * cost of the pizza order to the console. 
		 * 
		 */
		System.out.println("First PizzaOrder (newOrderOne)");
		System.out.println("-----------------");
		Pizza myPizza = new Pizza("large", 2, 1, 0);
		Pizza myPizzaToo = new Pizza();      //new Pizza using no argument constructor
		myPizza.setCheeseToppings(4);        //changing the number of cheese toppings
		myPizza.setSize("SmALL");            //change pizza size
		myPizzaToo.setHamToppings(2);        //adding toppings to default Pizza
		myPizzaToo.setPepperoniToppings(1);
		PizzaOrder newOrderOne = new PizzaOrder(myPizza, myPizzaToo);  //creating new PizzaOrder

		System.out.println(newOrderOne);    
		System.out.printf("Total cost of newOrderOne: $%d \n\n", newOrderOne.totalCost());
		
		/**
		 * the following code creates a new PizzaOrder object that is a copy of the 
		 * previous PizzaOrder object and prints the order to the console to verify that 
		 * the copy constructor worked correctly. It also modifies the copied order and 
		 * prints both orders to show that a change to the 2nd order does not change the first (the one
		 * that was copied). 
		 * It then creates and adds a pizza to the order and changes some of the pizza toppings.
		 */
		System.out.println("-----------------");
		System.out.println("Second PizzaOrder (NewOrderTwo)");
		System.out.println("-----------------");
		PizzaOrder newOrderTwo = new PizzaOrder(newOrderOne);  //uses copy constructor to create a new order
		
		newOrderTwo.getPizzaTwo().setHamToppings(4);      //makes a change in pizzaTwo
		System.out.printf("Total cost of NewOrderOne: $%d \n", newOrderOne.totalCost());     //shows that a change in order2 does not affect order1
		System.out.printf("Total cost of NewOrderTwo: $%d \n\n", newOrderTwo.totalCost());

		Pizza pizzaThree = new Pizza("small", 2, 3, 1);
		newOrderTwo.setPizzaNumber(3);
		newOrderTwo.setPizzaThree(pizzaThree);
		System.out.println(newOrderTwo);
		
		/**
		 * the following code makes a PizzaOrder with one pizza.
		 * It tests the blank PizzaOrder constructor and default Pizza 
		 * constructor.  It prints out the pizza order, then changes the pizza
		 * in the order to reflect a change in an order.  It then reprints the order
		 * to show that the order has changed. 
		 * 
		 */
		System.out.println("-----------------");
		System.out.println("Third PizzaOrder (PizzaOrderThree)");
		System.out.println("-----------------");
		PizzaOrder pizzaOrderThree = new PizzaOrder();
		System.out.println(pizzaOrderThree);      
		
		Pizza changedPizzaOrder = new Pizza("medium", 1, 2, 1);  //creating a new Pizza
		pizzaOrderThree.setPizzaOne(changedPizzaOrder);  //replacing the pizza in the order with the newly pizza 
		System.out.println("-----------------");
		System.out.println("Third PizzaOrder post-modification (PizzaOrderThree)");
		System.out.println("-----------------");
		System.out.println(pizzaOrderThree.getPizzaOne());   //shows method to return Pizza from order
		System.out.printf("Total cost of PizzaOrderThree: $%d \n\n", pizzaOrderThree.totalCost());
	}

}
