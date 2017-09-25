
public class Duelist {
	private String name;
	private double accuracy;
	private boolean stillAlive;
	
	public Duelist() {
		name = "unknown";
		accuracy = 0;
		stillAlive = true;
	}
	
	public Duelist (String name, double accuracy, boolean alive) {
		this.name = name;
		this.accuracy = accuracy;
		this.stillAlive = alive;
	}
	
	//accessor and mutator functions
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return (name + " Accuracy: " + accuracy + " A: " + stillAlive);
	}
	
	public double getAccuracy() {
		return accuracy;
	}
	
	public void setAccuracy(double accuracy) {
		if (accuracy >= 0 && accuracy <= 1) {
			this.accuracy = accuracy;
		}
		else {
			System.out.println("incorrect entry");
			System.exit(0);
		}
	}
	public boolean isAlive() {
		return stillAlive;
	}
	public void setStillAlive(boolean stillAlive) {
		this.stillAlive = stillAlive;
	}
	
	
	/**
	 * Performs the action of a duel shot and uses the shooter's accuracy to
	 * determine the outcome of the shot. If the shot is hit, it changes the 
	 * target's stillALive status to false
	 * 
	 * @param target  The duelist being shot at
	 */
	public void ShootAtTarget(Duelist target) {
		double randomNumber = Math.random();
		if (randomNumber <= accuracy) {
//			System.out.println(this.getName() + " accuracy: " + this.getAccuracy());
//			System.out.println(randomNumber);  
			target.setStillAlive(false);
			//System.out.println(target.getName() + " is dead.");
		}
	}	
}
