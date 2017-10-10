
public class MovieClassesDemo {

	public static void main(String[] args) {
		int lateDays = 3;
		Movie [] movies = new Movie[4];
		
		movies[0] = new Movie("nc-17", 12121, "Some Generic Movie");
		movies[1] = new Action("PG", 12122, "Threat Level Midnight");
		movies[2] = new Drama("r", 22332, "Sad Yet Happy Ending");
		movies[3] = new Comedy();
		
		movies[3].setRating("Pg-13");
		movies[3].setId(22131);
		movies[3].setMovieTitle("Hilarious Comedy Movie II");
		
		for (Movie m : movies) {
			System.out.println(m);
			System.out.printf("$%.2f in late fees.\n\n", m.calcLateFees(lateDays));
		}		
	}
}
