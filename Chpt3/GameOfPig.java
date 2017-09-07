import java.util.Scanner;

public class GameOfPig {
	public static int scoreHuman = 0;
	public static int scoreComputer = 0;
	public static boolean humanTurn = true;
	static Scanner keyboard = new Scanner(System.in);
	
	public static int rollDie() {
		int roll = (int)(Math.random() * 6) + 1;
		return roll;
	}
	
	public static int ComputerPlay()  
	{
		int turnScore = 0;
		int roll = -1;
		
		while (roll != 1)
		{
			roll = rollDie();
			System.out.println("The computer has rolled a " + roll + ".");
			turnScore += roll;
			if (turnScore + scoreComputer >= 100) 
			{
				return turnScore;
			}
			else if (turnScore >= 20)
			{
				System.out.println("Computer will hold. Turn score = " + turnScore);
				humanTurn = true;
				return turnScore;
			}
		}
		System.out.println("Computer's turn over.");
		humanTurn = true;
		return turnScore = 0;
	}
	
	
	public static int HumanPlay() 
	{
		int turnScore = 0;
		int roll = rollDie();
		System.out.println("It is your turn. Your first roll is: " + roll + ".");
		if (roll == 1)
		{
			System.out.println("You have rolled a 1. Turn over." );
		}
		else
		{
			turnScore += roll;
			System.out.println("You have rolled a " + roll + ".");
			System.out.println("Turn score total is " + turnScore + ".");
			System.out.println("Would you like to roll again or hold?");
			System.out.println("Enter a 1 for roll again, a 2 for hold.");
			int choice = keyboard.nextInt();
			while (choice == 1) 
			{
				roll = rollDie();
				if (roll == 1)
				{
					System.out.println("You have rolled a 1. Turn over." );
					humanTurn = false;
					return turnScore = 0;
				}
				else
				{
					turnScore += roll;
					System.out.println("You have rolled a " + roll + ".");
					System.out.println("Turn score total is " + turnScore + ".");
					System.out.println("Would you like to roll again or hold?");
					System.out.println("Enter a 1 for roll again, a 2 for hold.");
					choice = keyboard.nextInt();
				}
			}
			if (choice != 2) 
			{
				System.out.println("Invalid entry. Enter a 1 or 2.");
				choice = keyboard.nextInt();
			}
		}
		
		System.out.println("Turn score total is " + turnScore + ".");
		humanTurn = false;
		return turnScore;
	}

	public static void main(String[] args) {
		
		System.out.println("Welcome to the game of Pig!");

		while (scoreHuman < 100 && scoreComputer < 100) 
		{
			System.out.println("COMPUTER: " + scoreComputer + " YOU: " + scoreHuman);
			if (humanTurn) 
			{
				scoreHuman += HumanPlay();
			}
			else 
			{
				scoreComputer += ComputerPlay();
			}
		}
		if (scoreHuman >= 100) 
		{
			System.out.println("Congratulations, you've won!");
			System.out.println("FINAL SCORE: You: " + scoreHuman + " Computer: " + scoreComputer);
		}
		else
		{
			System.out.println("Sorry, you've lost!");
			System.out.println("FINAL SCORE: You: " + scoreHuman + " Computer: " + scoreComputer);
		}
		
		keyboard.close();
	}

}
