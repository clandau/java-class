/**
 * class for a movie of the drama genre, with
 * its own late fees. 
 *
 */
public class Drama extends Movie{
	private double lateFee = 2.00;
	
	public Drama() {
		super();
	}
	
	public Drama(String rating, int id, String title) {
		super(rating, id, title);
	}
	
	public double calcLateFees(int numberOfDays) {
		return lateFee * numberOfDays;
	}
	
	public String toString() {
		return ("Title: " + getMovieTitle() + "\nID Number: " + getId() + "\nMPAA Rating: " 
	+ getRating() + "\nGenre: Drama");
	}
}
