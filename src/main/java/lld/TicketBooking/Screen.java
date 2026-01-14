package lld.TicketBooking;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Screen {
    private long screenId;
    private String screenName;
    Theatre theatre;
    List<Show>show;
    List<Seat> seats;

    public Screen(long screenId, String screenName, Theatre theatre) {
        this.screenId = screenId;
        this.screenName = screenName;
        this.theatre = theatre;
        this.seats = new ArrayList<>();
    }

    public Screen(long screenId, String screenName, List<Seat> seats) {
        this.screenId = screenId;
        this.screenName = screenName;
        this.seats = seats;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public long getScreenId() {
        return screenId;
    }

    public void setScreenId(long screenId) {
        this.screenId = screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public List<Show> getShow() {
        return show;
    }

    public void setShow(List<Show> show) {
        this.show = show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

//    @Override
//    public String toString() {
//        return "Screen{" +
//                "screenId=" + screenId +
//                ", screenName='" + screenName + '\'' +
//                ", theatre=" + theatre +
//                ", show=" + show +
//                ", seats=" + seats +
//                '}';
//    }
}
