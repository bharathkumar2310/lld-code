package lld.TicketBooking;

import java.time.LocalDateTime;
import java.util.List;

public class ShowsForMovieResponse {

    long showId;
    String theatreName;
    String ScreenName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public ShowsForMovieResponse(Show show) {
        this.showId = show.getShowId();
        this.theatreName = show.getScreen().getTheatre().getTheatreName();
        this.ScreenName = show.getScreen().getScreenName();
        this.startTime = show.getStartTime();
        this.endTime = show.getEndTime();
    }

    @Override
    public String toString() {
        return "ShowsForMovieResponse{" +
                "showId=" + showId +
                ", theatreName='" + theatreName + '\'' +
                ", ScreenName='" + ScreenName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
