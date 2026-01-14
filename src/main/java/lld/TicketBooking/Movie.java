package lld.TicketBooking;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Movie {

    private String movieName;
    private Duration movieDuration;
    //private Cast cast;


    public Movie(String movieName, Duration movieDuration) {
        this.movieName = movieName;
        this.movieDuration = movieDuration;
    }

    public Duration getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(Duration movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", movieDuration=" + movieDuration +
                '}';
    }
}
