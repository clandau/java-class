/**
 * Runs duels between members of the class Duelist.  Goes through
 * every person's turn until all but one are dead.  Prints percent out of
 * 10,000 duels that each duelest has won. Compares two different dueling strategies. 
 * 
 * @author Courtney
 *
 */
public class DuelistGameSimulation {
	private static Duelist aaron = new Duelist("Aaron", 0.333, true);
	private static Duelist bob = new Duelist("Bob", 0.5, true);
	private static Duelist charlie = new Duelist("Charlie", 1, true);
	
	//alternate strategy variable to store whether it is Aaron's first shot overall
	private static boolean aaronsFirstShot;  
	
	/**each person's turn fires at the person still alive with the
	 * highest accuracy
	 * 
	 */
	public static void aaronsTurn() {
		if(aaron.isAlive()) {
			if(charlie.isAlive()) {
				aaron.ShootAtTarget(charlie);
			}
			else if(bob.isAlive()) {
				aaron.ShootAtTarget(bob);
			}
		}
	}
	
	public static void aaronsTurnAlternate() {
//		System.out.println("aaron's first shot? " + aaronsFirstShot);
		if (!aaronsFirstShot) {
			if(aaron.isAlive()) {
				if(charlie.isAlive()) {
					aaron.ShootAtTarget(charlie);
				}
				else if(bob.isAlive()) {
					aaron.ShootAtTarget(bob);
				}
			}
		}
		aaronsFirstShot = false;
	}
	
	public static void bobsTurn() {
		if(bob.isAlive()) {
			if(charlie.isAlive()) {
				bob.ShootAtTarget(charlie);
			}
			else if(aaron.isAlive()) {
				bob.ShootAtTarget(aaron);
			}
		}
	}
	
	public static void charliesTurn() {
		if(charlie.isAlive()) {
			if(aaron.isAlive()) {
				charlie.ShootAtTarget(aaron);
			}
			else if(bob.isAlive()) {
				charlie.ShootAtTarget(bob);
			}
		}
	}
	/**method to simulate one duel. The method loops through
	 * each player's turn until there is only one surviving duelist.
	 * 
	 * @return returns the duelist who has won the duel.
	 */
	public static Duelist startDuel() {
		int stillAlive = 3;

		while(stillAlive > 1) {
			stillAlive = 3;
			if(aaron.isAlive()) {
				aaronsTurn();
			}
			else stillAlive--;
			if(bob.isAlive()) {
				bobsTurn();
			}
			else stillAlive--;
			if(charlie.isAlive()) {
				charliesTurn();
			}
			else stillAlive--;
		}
		
		if (aaron.isAlive()) return aaron;
		else if (bob.isAlive()) return bob;
		else return charlie;
	}

	public static Duelist startDuelAlternate() {
		aaronsFirstShot = true;  //only used for alternate strategy
		int stillAlive = 3;

		while(stillAlive > 1) {
			stillAlive = 3;
			if(aaron.isAlive()) {
				aaronsTurnAlternate();
			}
			else stillAlive--;
			if(bob.isAlive()) {
				bobsTurn();
			}
			else stillAlive--;
			if(charlie.isAlive()) {
				charliesTurn();
			}
			else stillAlive--;
		}
		
		if (aaron.isAlive()) return aaron;
		else if (bob.isAlive()) return bob;
		else return charlie;
	}
	
	public static void main(String[] args) {
		int totalIterations = 10000;
		int aaronWins = 0;
		int bobWins = 0;
		int charlieWins = 0;
		
		while (totalIterations > 0) {
			aaron.setStillAlive(true);
			bob.setStillAlive(true);
			charlie.setStillAlive(true);
			Duelist winner = startDuel();
			
			switch(winner.getName()) {
			case "Aaron":
				aaronWins++;
				break;
			case "Bob":
				bobWins++;
				break;
			case "Charlie":
				charlieWins++;
				break;
			}	
			totalIterations--;
		}
		
		System.out.printf("Aaron won %d/10000 duels or %.2f%%.%n", aaronWins, (double)aaronWins/100);
		System.out.printf("Bob won %d/10000 duels or %.2f%%.%n", bobWins, (double)bobWins/100);
		System.out.printf("Charlie won %d/10000 duels or %.2f%%.%n", charlieWins, (double)charlieWins/100);
		
		/**
		 * game play for alternate strategy
		 * 
		 * I believe that the strategy of Aaron missing his first shot does not
		 * change his chances of winning.  Bob however seems to win a little less, and
		 * Charlie (the best shooter) wins more often with this strategy.  
		 * 
		 */
		totalIterations = 10000;
		aaronWins = 0;
		bobWins = 0;
		charlieWins = 0;
		
		while (totalIterations > 0) {
			aaron.setStillAlive(true);
			bob.setStillAlive(true);
			charlie.setStillAlive(true);
			Duelist winnerAlternate = startDuelAlternate();
			//System.out.println("winner: " + winnerAlternate.getName());
			switch(winnerAlternate.getName()) {
			case "Aaron":
				aaronWins++;
				break;
			case "Bob":
				bobWins++;
				break;
			case "Charlie":
				charlieWins++;
				break;
			}	
			totalIterations--;
		}
		System.out.println("---------------------------------");
		System.out.println("Alternate Strategy");
		System.out.println("---------------------------------");
		System.out.printf("Aaron won %d/10000 duels or %.2f%%.%n", aaronWins, (double)aaronWins/100);
		System.out.printf("Bob won %d/10000 duels or %.2f%%.%n", bobWins, (double)bobWins/100);
		System.out.printf("Charlie won %d/10000 duels or %.2f%%.%n", charlieWins, (double)charlieWins/100);
		
	}
}
