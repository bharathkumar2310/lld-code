package lld.TicketBooking;

import java.time.LocalDateTime;
import java.util.List;

public class Show {
    private Long showId;
    private Movie movie;
    private Screen screen;
    private List<ShowSeat> showSeat;
    private LocalDateTime  startTime;
    private LocalDateTime endTime;

    public Show(Long showId, Movie movie, Screen screen, List<ShowSeat> showSeat, LocalDateTime startTime, LocalDateTime endTime) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.showSeat = showSeat;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public List<ShowSeat> getShowSeat() {
        return showSeat;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Show{" +
                "showId=" + showId +
                ", movie=" + movie +
                ", screen=" + screen +
                ", showSeat=" + showSeat +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}


