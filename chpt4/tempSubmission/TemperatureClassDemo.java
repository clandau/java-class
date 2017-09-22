import java.util.Scanner;

public class TemperatureClassDemo {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		//create 2 instances of Temperature class, one which prompts for input
		Temperature firstTemp = new Temperature();
		//test constructor with both arguments
		Temperature secondTemp = new Temperature(32, 'F');
		//test constructor with temperature argument
		Temperature thirdTemp = new Temperature(28.5);
		//test constructor with scale argument
		Temperature fourthTemp = new Temperature('c');
		//additional instances for testing purposes requested by programming project instructions
		Temperature fifthTemp = new Temperature(0, 'c');
		Temperature sixthTemp = new Temperature(-40, 'C');
		Temperature seventhTemp = new Temperature(-40.0, 'F');
		Temperature eighthTemp = new Temperature(100.0, 'C');
		Temperature ninthTemp = new Temperature(212.0, 'f');
		
		int choice = -1;
		while (choice != 8) {
			System.out.println("");
			System.out.println("Choose one option:");
			System.out.println("1: Enter temperature and scale information for instance initialized with blank constructor.");
			System.out.println("2: Change the default temperature for instance initialized with only the scale.");
			System.out.println("3: Change the default scale for instance initialized with only the temperature.");
			System.out.println("4: See sample Temperature instances using toString method.");
			System.out.println("5: See sample temperature comparisons as requested in textbook.");
			System.out.println("6: See examples of comparison functions.");
			System.out.println("7: See examples of getFahrenheit and getCelsius methods.");
			System.out.println("8: Exit.");
			choice = keyboard.nextInt();
			switch (choice) {
			case 1:
				//testing the constructor that is initialized with no arguments 
				//also testing the setTempAndScale method
				System.out.println("");
				System.out.println("Set values for firstTemp.");
				System.out.println("Enter a new temperature: ");
				double temperature = keyboard.nextDouble();
				
				System.out.println("Enter a new scale: ");
				String newScaleString = keyboard.next();
				char newScale = newScaleString.charAt(0);
				firstTemp.setTempAndScale(temperature, newScale);
				System.out.println("firstTemp's attributes: " + firstTemp.toString());
				break;
			case 2:
				//testing the constructor which is initialized with only a scale argument
				//also testing the setTemperature method
				System.out.println("fourthTemp's current attributes: " + fourthTemp.toString());
				System.out.println("Enter a new temperature for fourthTemp.");
				double newTemperature = keyboard.nextDouble();
				fourthTemp.setTemperature(newTemperature);
				System.out.println("fourthTemp's new attributes: " + fourthTemp.toString());
				break;
			case 3:
				//testing the constructor which is initialized with only a temperature argument
				//also testing the setScale method
				System.out.println("thirdTemp's current attributes: " + thirdTemp.toString());
				System.out.println("Enter a new scale for thirdTemp.");
				String scaleString = keyboard.next();
				char scale = scaleString.charAt(0);
				thirdTemp.setScale(scale);
				System.out.println("thirdTemp's attributes.");
				System.out.println(thirdTemp.toString());
				break;
			case 4:
				//testing the toString() method's operation
				System.out.println("firstTemp's attributes: " + firstTemp.toString());
				System.out.println("secondTemp's attributes: " + secondTemp.toString());
				System.out.println("thirdTemp's attributes: " + thirdTemp.toString());
				System.out.println("fourthTemp's attributes: " + fourthTemp.toString());
				break;
			case 5:
				//testing 32F equals 0C
				if (fifthTemp.equals(secondTemp)) {
					System.out.println(fifthTemp.toString() + " equals " + secondTemp.toString());
				}
				else {
					System.out.println(fifthTemp.toString() + " does not equal " + secondTemp.toString());
				}
				//testing -40F equals -40C
				if (sixthTemp.equals(seventhTemp)) {
					System.out.println(sixthTemp.toString() + " equals " + seventhTemp.toString());
				}
				else {
					System.out.println(sixthTemp.toString() + " does not equal " + seventhTemp.toString());
				}
				
				//testing 100C equals 212F
				if (eighthTemp.equals(ninthTemp)) {
					System.out.println(eighthTemp.toString() + " equals " + ninthTemp.toString());
				}
				else {
					System.out.println(eighthTemp.toString() + " does not equal " + ninthTemp.toString());
				}				
				break;
			case 6:
				//testing equals method in case of not equal
				if (thirdTemp.equals(sixthTemp)) {
					System.out.println(thirdTemp.toString() + " is equal to " + sixthTemp);
				}
				else {
					System.out.println(thirdTemp.toString() + " is not equal to " + sixthTemp);
				}

				//testing both cases lessThan method
				if (thirdTemp.lessThan(sixthTemp)) {
					System.out.println(thirdTemp.toString() + " is less than " + sixthTemp.toString());
				}
				else {
					System.out.println(thirdTemp.toString() + " is not less than " + sixthTemp.toString());
				}
				if (sixthTemp.lessThan(thirdTemp)) {
					System.out.println(sixthTemp.toString() + " is less than " + thirdTemp.toString());
				}
				else {
					System.out.println(sixthTemp.toString() + " is not less than " + thirdTemp.toString());
				}
				
				//testing both cases greaterThan method
				if (seventhTemp.greaterThan(ninthTemp)) {
					System.out.println(seventhTemp.toString() + " is greater than " + ninthTemp.toString());
				}
				else {
					System.out.println(seventhTemp.toString() + " is not greater than " + ninthTemp.toString());
				}
				if (ninthTemp.greaterThan(seventhTemp)) {
					System.out.println(ninthTemp.toString() + " is greater than " + seventhTemp.toString());
				}
				else {
					System.out.println(ninthTemp.toString() + " is not greater than " + seventhTemp.toString());
				}
				break;
			case 7:
				//testing the conversions done with getFahrenheit and getCelsius methods
				System.out.println("firstTemp in Fahrenheit: " + firstTemp.getFahrenheit() + " degrees F");
				System.out.println("firstTemp in Celsius: " + firstTemp.getCelsius() + " degrees C");
				
				System.out.println("secondTemp in Fahrenheit: " + secondTemp.getFahrenheit() + " degrees F");
				System.out.println("secondTemp in Celsius: " + secondTemp.getCelsius() + " degrees C");
				break;
			case 8:
				System.out.println("Goodbye.");
				System.exit(0);
			default:
				System.out.println("Incorrect choice, try again.");
				break;
			}
		}
		keyboard.close();
	}
}
