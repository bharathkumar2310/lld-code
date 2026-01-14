package lld.TicketBooking;

import java.time.Duration;
import java.util.List;

public class MovieService {

    private BookMyShowApp bookMyShowApp;
    public MovieService(BookMyShowApp bookMyShowApp) {
        this.bookMyShowApp = bookMyShowApp;
    }

    public void addMovie(String movieName, long hours) {
          Movie movie = new Movie(movieName, Duration.ofHours(hours));
          bookMyShowApp.getMovies().add(movie);
     }

     public List<Movie> showMovies() {
        return bookMyShowApp.getMovies();
     }

}
