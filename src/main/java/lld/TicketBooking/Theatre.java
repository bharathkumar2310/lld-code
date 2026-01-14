package lld.TicketBooking;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private String theatreName;
    private List<Screen> screen;

    public Theatre(String theatreName) {
        this.theatreName = theatreName;
        this.screen = new ArrayList<>();
    }

    public Theatre(String theatreName, List<Screen> screen) {
        this.theatreName = theatreName;
        this.screen = screen;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public List<Screen> getScreen() {
        return screen;
    }

    public void setScreen(List<Screen> screen) {
        this.screen = screen;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "theatreName='" + theatreName + '\'' +
                ", screen=" + screen +
                '}';
    }
}
