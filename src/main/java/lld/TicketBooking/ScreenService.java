package lld.TicketBooking;

import java.util.List;

public class ScreenService {

    private BookMyShowApp bookMyShowApp;
    private static int screenId = 0;
    private static int normalSeatId = 0;
    private static int premiumSeatId = 0;

    public ScreenService(BookMyShowApp bookMyShowApp) {
        this.bookMyShowApp = bookMyShowApp;
    }

    public String createScreen(String theatreName, String screenName) {
        Theatre theatre = bookMyShowApp.getTheatres().stream().filter((theat) -> theat.getTheatreName().equals(theatreName)).findFirst().orElse(null);
        if(theatre == null) {
            throw new RuntimeException("Theatre not found");
            // throw custom exception
        }
        Screen screen = new Screen(++screenId, screenName, theatre);
        theatre.getScreen().add(screen);
        return "Screen created successfully";
    }


    public String addNormalSeatsToScreen(int noOfSeats, String theatreName, String screenName ) {
        for(int i=0; i<noOfSeats; i++) {
            Theatre theatre = bookMyShowApp.getTheatres().stream().filter((theat) -> theat.getTheatreName().equals(theatreName)).findFirst().orElse(null);
            if(theatre == null) {
                throw new RuntimeException("Theatre not found");
                // throw custom exception
            }
            Screen screen = theatre.getScreen().stream().filter((scr) -> scr.getScreenName().equals(screenName)).findFirst().orElse(null);
            if(screen == null) {
                throw new RuntimeException("Screen not found");
                // throw custom exception
            }
            Seat seat = new Seat(++normalSeatId + "N", SeatType.NORMAL);
            screen.getSeats().add(seat);

        }
        return noOfSeats + " of normal seats added successfully";
    }

    public String addPremiumSeatsToScreen(int noOfSeats, String theatreName, String screenName) {
        for(int i=0; i<noOfSeats; i++) {
            Theatre theatre = bookMyShowApp.getTheatres().stream().filter((theat) -> theat.getTheatreName().equals(theatreName)).findFirst().orElse(null);
            if(theatre == null) {
                throw new RuntimeException("Theatre not found");
                // throw custom exception
            }
            Screen screen = theatre.getScreen().stream().filter((scr) -> scr.getScreenName().equals(screenName)).findFirst().orElse(null);
            if(screen == null) {
                throw new RuntimeException("Screen not found");
                // throw custom exception
            }
            Seat seat = new Seat(++premiumSeatId + "N", SeatType.PREMIUM);
            screen.getSeats().add(seat);

        }
        return noOfSeats + " of premium seats added successfully";
    }
}
