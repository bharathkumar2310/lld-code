package lld.TicketBooking;

import lld.TicketBooking.*;

import java.util.ArrayList;
import java.util.List;

public class UtilClass {

    private BookMyShowApp app;

    public UtilClass(BookMyShowApp app) {
        this.app = app;
    }

    private static long screenId = 0;


    public void init() {
        createTheatres();
    }

    // ---------- THEATRES ----------
    private void createTheatres() {

        // THEATRE 1
        List<Screen> theatre1Screens = new ArrayList<>();


        createScreen(
                "Screen1",
                createSeats(10, 5),
                theatre1Screens
        );

        createScreen(
                "Screen2",
                createSeats(10, 10),
                theatre1Screens
        );

        Theatre theatre1 = createTheatre("Theatre1", theatre1Screens);

        // THEATRE 2
        List<Screen> theatre2Screens = new ArrayList<>();

        createScreen(
                "Screen1",
                createSeats(5, 10),
                theatre2Screens
        );

        createScreen(
                "Screen2",
                createSeats(15, 5),
                theatre2Screens
        );

        Theatre theatre2 = createTheatre("Theatre2", theatre2Screens);

        app.getTheatres().add(theatre1);
        app.getTheatres().add(theatre2);


    }

    // ---------- SEATS ----------
    private List<Seat> createSeats(int normalCount, int premiumCount) {
        List<Seat> seats = new ArrayList<>();

        for (int i = 1; i <= normalCount; i++) {
            seats.add(new Seat("N" + i, SeatType.NORMAL));
        }

        for (int i = 1; i <= premiumCount; i++) {
            seats.add(new Seat("P" + i, SeatType.PREMIUM));
        }

        return seats;
    }

    // ---------- SCREEN ----------
    private void createScreen(String name, List<Seat> seats, List<Screen> screenList) {
        Screen screen = new Screen(++screenId, name, seats);
        screenList.add(screen);
    }

    // ---------- THEATRE ----------
    private Theatre createTheatre(String name, List<Screen> screens) {
        Theatre theatre = new Theatre(name, screens);
        for (Screen screen : screens) {
            screen.setTheatre(theatre);
        }
        return theatre;
    }
}
