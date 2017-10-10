/**
 * class for a movie of the comedy genre, with 
 * its own late fees
 *
 */
public class Comedy extends Movie {
	private double lateFee = 2.50;
	
	public Comedy() {
		super();
	}
	
	public Comedy(String rating, int id, String title) {
		super(rating, id, title);
	}
	
	public double calcLateFees(int numberOfDays) {
		return lateFee * numberOfDays;
	}
	
	public String toString() {
		return ("Title: " + getMovieTitle() + "\nID Number: " + getId() + "\nMPAA Rating: " 
	+ getRating() + "\nGenre: Comedy");
	}
}
