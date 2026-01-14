package lld.TicketBooking;

public class TheatreService {

    private BookMyShowApp bookMyShowApp;

    public TheatreService(BookMyShowApp bookMyShowApp) {
        this.bookMyShowApp = bookMyShowApp;
    }


    public String addTheatre(String theatreName) {
        Theatre theatre = new Theatre(theatreName);
        bookMyShowApp.getTheatres().add(theatre);
        return theatreName + " created successfully";

    }
}
