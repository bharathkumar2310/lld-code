package lld.TicketBooking;

import java.util.List;
import java.util.Map;

public class MappingClass {

    private Map<Movie, List<Show>> showsForEachMovie;
    private Map<Screen, List<Show>>showsForEachScreen;
    private Map<Theatre, List<Screen>>screensForEachTheatre;
}
