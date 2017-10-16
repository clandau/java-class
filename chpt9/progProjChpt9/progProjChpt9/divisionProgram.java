package progProjChpt9;

import java.util.Scanner;
import java.util.InputMismatchException;

public class divisionProgram {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean dataComplete = false;
		int n1 = 0, n2 = 0;
		double r = 0;
		
		while(!dataComplete) {
			try {
				System.out.println("Enter two numbers and I will divide them.");
				System.out.println("Enter the numerator:");
				n1 = scan.nextInt();
				System.out.println("Enter the denominator:");	
				n2 = scan.nextInt();
				if (n2 == 0) throw new DivisionByZeroException();
				r = (double)n1/n2;
				dataComplete = true;
			}
			
			catch(InputMismatchException e) {
				System.out.println("Integer not entered, Try again.");
				scan.nextLine();
			}
			
			catch(DivisionByZeroException e) {
				System.out.println("Cannot divide by zero. Try again.");
			}
		}
		System.out.printf("%d divided by %d equals %.2f\n", n1, n2, r);
		scan.close();
	}
}
