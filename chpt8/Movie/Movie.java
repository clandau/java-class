/**
 * Class for a generic movie object with a standard late fee.
 * Class invariant: a movie always has a title, id and MPAA rating.
 * @author Courtney
 */
public class Movie {
	private String MPAArating;
	private int idNumber;
	private String movieTitle;
	
	public Movie() {
		MPAArating = null;
		idNumber = 00000;
		movieTitle = "no title";
	}
	
	public Movie(String rating, int id, String movieTitle) {
		if (checkRating(rating)) MPAArating = rating.toUpperCase();
		else {
			System.out.println("Incorrect rating.");
			System.exit(0);
		}
		idNumber = id;
		this.movieTitle = movieTitle;
	}
	
	public String getRating() {
		return MPAArating;
	}
	
	public void setRating(String rating) {
		if (checkRating(rating)) MPAArating = rating.toUpperCase();
		else {
			System.out.println("Incorrect rating.");
			System.exit(0);
		}
	}
	
	public int getId() {
		return idNumber;
	}
	
	public void setId(int id) {
		this.idNumber = id;
	}
	
	public String getMovieTitle() {
		return movieTitle;
	}
	
	public void setMovieTitle(String title) {
		movieTitle = title;
	}
	
	public boolean equals(Movie otherMovie) {
		return (this.idNumber == otherMovie.getId());
	}
	
	public String toString() {
		return ("Title: " + movieTitle + "\nID Number: " + idNumber + "\nMPAA Rating: " + MPAArating);
	}
	
	/**
	 * helper function to determine if rating entered is one of the
	 * acceptable entries for a MPAA rating. 
	 * @param rating
	 * @return
	 */
	public static boolean checkRating(String rating) {
		return (rating.toUpperCase().equals("G") || rating.toUpperCase().equals("PG")  || rating.toUpperCase().equals("PG-13")  
				|| rating.toUpperCase().equals("R") || rating.toUpperCase().equals("NC-17"));
	}
	
	public double calcLateFees(int days) {
		return days * 2.00;
	}
}
