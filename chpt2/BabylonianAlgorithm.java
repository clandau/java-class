/*
IT504 Absolute Java Chapter 2
Programming project number 1
*/

import java.util.Scanner;

public class BabylonianAlgorithm 
{
    public static double babylonianAlgorithm (double input) 
    {   
        int count = 5;
        double guess = input/2;
        double r = input/guess;
        
        while (count > 0) 
        {
            guess = (guess + r)/2;
            r = input/guess;
            count--;
        }
        return guess;
    }
    
    public static void main (String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
    
        System.out.print("Enter a number and I will estimate the square root: ");
        double n = keyboard.nextDouble();
        while (n <= 0) 
        {
            System.out.println("Invalid entry.");
            System.out.print("Enter a number and I will estimate the square root: ");
            n = keyboard.nextDouble();
            
        }
        double answer = babylonianAlgorithm(n);
        System.out.printf("The estimated square root of %.2f is: %.2f.%n", n, answer);
        keyboard.close();
    }
}