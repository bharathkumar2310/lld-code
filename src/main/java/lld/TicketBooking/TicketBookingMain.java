package lld.TicketBooking;

import java.awt.print.Book;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class TicketBookingMain {
    public static void main(String[] args) {

        BookMyShowApp app = new BookMyShowApp();
        UtilClass utilClass = new UtilClass(app);
        utilClass.init();

        MovieService movieService = new MovieService(app);
        movieService.addMovie("movie1" , 3);
        movieService.addMovie("movie2" , 2);
        movieService.addMovie("movie3" , 3);

        // show all the movies
        List<Movie> movies = app.showMovies();
        movies.stream().forEach((movie) ->System.out.println(movie.toString()));

        //creating shows for movie1 in theatre1---> only screen1 will be used by theare1 for movie1
        ShowService showService = new ShowService(app);
        showService.createShow("Theatre1", "movie1", 3, "Screen1", LocalDateTime.of(2026,1,4,6,0));

        //creating shows for movie1 in theatre2---> only screen2 will be used by theare2 for movie1
        showService.createShow("Theatre2", "movie1", 2, "Screen2", LocalDateTime.of(2026,1,4,5,0));

       // showing all the shows for a movie
        Movie movie1 = movies.stream().filter((movie) -> movie.getMovieName().equals("movie1")).findFirst().orElse(null);
        List<Show> showsForMovie1 = app.getShowForMovies().get(movie1);
        showsForMovie1.stream().forEach((show) -> System.out.println(new ShowsForMovieResponse(show).toString()));


        // user selects one of the shows

        Show userSelectedShow = showsForMovie1.get(0);
        //showing seats for that show

        userSelectedShow.getShowSeat().stream().forEach((seat) ->System.out.println(seat.toString()));

        // user selects a list of seats and tries booking those seats

        ShowSeat seatN1 =  userSelectedShow.getShowSeat().stream().filter((seat) ->seat.getSeat().getSeatNo().equals("N1")).findFirst().orElse(null);
        ShowSeat seatN2 =  userSelectedShow.getShowSeat().stream().filter((seat) ->seat.getSeat().getSeatNo().equals("N2")).findFirst().orElse(null);











    }
}
