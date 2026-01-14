package lld.TicketBooking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ShowService {

    private BookMyShowApp bookMyShowApp;
    private static long showId = 0;
    public ShowService(BookMyShowApp bookMyShowApp) {
        this.bookMyShowApp = bookMyShowApp;
    }

    public void createShow(String theatreName, String movieName, int noOfShows, String screenName, LocalDateTime firstShowStartTime) {
        Theatre theatre = bookMyShowApp.getTheatres().stream().filter((theatr) -> theatr.getTheatreName().equals(theatreName)).findFirst().orElse(null);
        Screen screen = theatre.getScreen().stream().filter((scr) ->scr.getScreenName().equals(screenName)).findFirst().orElse(null);
        Movie movie = bookMyShowApp.getMovies().stream().filter((mov)->mov.getMovieName().equals(movieName)).findFirst().orElse(null);
        List<Seat>seats = screen.getSeats();
        long movieDuration = movie.getMovieDuration().toHours();
        long gapBetweenShowsInHours = 1;

        for(int i=0;i<noOfShows; i++) {
            List<ShowSeat>showSeats = new ArrayList<>();
            seats.stream().forEach((seat)-> showSeats.add(new ShowSeat(seat,SeatStatus.AVAILABLE)));
            LocalDateTime startTime = firstShowStartTime.plusHours(i * (movieDuration + gapBetweenShowsInHours));
            LocalDateTime endTime = startTime.plusHours(movieDuration);

            Show show = new Show(++showId, movie, screen, showSeats, startTime, endTime );
            List<Show> showsForScreen = screen.getShow() == null ? new ArrayList<>(): screen.getShow();
            showsForScreen.add(show);
            List<Show>showsForMovie  = bookMyShowApp.getShowForMovies().get(movie) == null ? new ArrayList<>() : bookMyShowApp.getShowForMovies().get(movie);
            showsForMovie.add(show);
            bookMyShowApp.getShowForMovies().put(movie, showsForMovie);

        }
    }

    public List<Show>getAllShowsForAMovie(Movie movie) {
        Map<Movie, List<Show>> showForMovies =bookMyShowApp.getShowForMovies();
        List<Show> shows = showForMovies.get(movie);
         if(showForMovies.isEmpty()) {
            throw new RuntimeException("No shows are there for this movie");
        }
        return shows;

    }
}
