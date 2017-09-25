
public class DuelestGameSimulation {
	private static Duelist aaron = new Duelist("Aaron", 0.333, true);
	private static Duelist bob = new Duelist("Bob", 0.5, true);
	private static Duelist charlie = new Duelist("Charlie", 1, true);
	
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
	 * @return returns a string saying who has won the duel
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

	public static void main(String[] args) {
		int totalIterations = 10000;
		int aaronWins = 0;
		int bobWins = 0;
		int charlieWins = 0;
		
		//System.out.println(startDuel());  //test of single startDuel method
		
		while (totalIterations > 0) {
			aaron.setStillAlive(true);
			bob.setStillAlive(true);
			charlie.setStillAlive(true);
			Duelist winner = startDuel();
			//System.out.println(winner.getName());
			
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
		
		System.out.println("Aaron won " + aaronWins + "/10,000 duels or " + aaronWins/10000 + "%");
		System.out.println("Bob's wins: " + bobWins);
		System.out.println("Charlie's wins: " + charlieWins);
	}
}
