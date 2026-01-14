package lld.TicketBooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookMyShowApp {

    private List<User> users = new ArrayList<>();
    private  List<Theatre> theatres = new ArrayList<>();
    private List<Movie> movies = new ArrayList<>();
    private Map<Movie, List<Show>> showForMovies = new HashMap<>();


    public List<User> getUsers() {
        return users;
    }

    public  List<Theatre> getTheatres() {
        return theatres;
    }


    public List<Movie> getMovies() {
        return movies;
    }

    public List<Movie>showMovies() {
        return getMovies();
    }

    public Map<Movie, List<Show>> getShowForMovies() {
        return showForMovies;
    }


}
