/**
 * A class to input diving scores from 7 judges and
 * calculate the final score with the degree of
 * difficulty after dropping the best and worst scores.
 * 
 * Programming project Chapter 6 Number 1
 * @author Courtney Landau
 * 
 */
import java.util.Scanner;

public class DivingScores {

    private double degreeOfDifficulty;
    private double[] scores = new double[7];
    Scanner keyboard = new Scanner(System.in);
    
    public DivingScores() {
        System.out.println("Enter the diver's degree of difficulty: ");
        double tempInput = keyboard.nextDouble();
        while (tempInput < 1.2 || tempInput > 3.8) {
        		System.out.println("Error. Incorrect degree of difficulty.");
        		System.out.println("Enter a value between 1.2 and 3.8.");
        		tempInput = keyboard.nextDouble();
        }
        degreeOfDifficulty = tempInput;
        fillScores();
        }
    
    public DivingScores(double degreeOfDifficulty, double scores[]) {
        this.degreeOfDifficulty = degreeOfDifficulty;
        for (int i=0; i<scores.length; i++) {
        		if(scores[i] < 0 || scores[i]> 10) {
        			System.out.println("Error. Incorrect score value found.");
        			System.exit(0);
        		}
        		else {
        			this.scores[i] = scores[i];
        		}
        }
    }
    
    public void fillScores() {
        System.out.println("Enter the seven scores: ");
        for (int i=0; i<this.scores.length; i++) {
        		double scoreInput = keyboard.nextDouble();
        		while (scoreInput < 0 || scoreInput > 10) {
        			System.out.println("Error. Incorrect entry.");
        			System.out.println("Enter a score between 0 and 10: ");
        			scoreInput = keyboard.nextDouble();
        		}
        		this.scores[i] = scoreInput;
        }
        keyboard.close();
    }
    /**
     * prints the final score to the screen
     * 
     */
    public void displayFinalScore() {
    		double finalScore = finalScore();
    		System.out.printf("Final score: %1.1f\n", finalScore);
    }
    
    /**
    *   calculates the overall score for the dive. 
    *   
    *   @return final score
    */
    public double finalScore() {
    		double finalScore = 0;  
    		double maxValue = scores[0], minValue = scores[1]; //hold the values of the min and max scores
    		int maxLocation = 0, minLocation = 1;  //hold the index locating the min and max scores
    	
    	//loops through arry to find the highest and lowest scores
    	for (int i=0; i<scores.length; i++) {
    		if (scores[i] > maxValue) {
    			maxValue = scores[i];
    			maxLocation = i;
    		}
    		else if (scores[i] < minValue) {  
    			minValue = scores[i];
    			minLocation = i;	
    		}
    	}   
		
    	for (int i=0; i<scores.length; i++) {

    		if(i == maxLocation || i == minLocation) continue;
    		else {   
    			finalScore += scores[i];
    		}
    	}
    	return finalScore * degreeOfDifficulty * 0.6;
    }
}