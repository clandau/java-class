/**
 * Class for a movie in the action genre, with its own 
 * specific late fee cost per day.
 *
 */
public class Action extends Movie {
	private double lateFee = 3.00;
	
	public Action() {
		super();
	}
	
	public Action(String rating, int id, String title) {
		super(rating, id, title);
	}
	
	public String toString() {
		return ("Title: " + getMovieTitle() + "\nID Number: " + getId() + "\nMPAA Rating: " 
	+ getRating() + "\nGenre: Action");
	}
	
	public double calcLateFees(int numberOfDays) {
		return lateFee * numberOfDays;
	}

}
