package lld.TicketBooking;

import java.util.List;
import java.util.concurrent.*;

public class SeatLockCleanupService {

    private final BookMyShowApp app;
    private static final int LOCK_TIMEOUT_MINUTES = 5;

    public SeatLockCleanupService(BookMyShowApp app) {
        this.app = app;
    }

    public void start() {
        ScheduledExecutorService scheduler =
                Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(
                this::cleanupExpiredLocks,
                1,          // initial delay
                1,          // run every 1 minute
                TimeUnit.MINUTES
        );
    }

    private void cleanupExpiredLocks() {
        for (Theatre theatre : app.getTheatres()) {
            for (Screen screen : theatre.getScreen()) {
                for (Show show : screen.getShow()) {
                    for (ShowSeat seat : show.getShowSeat()) {
                        seat.unlockIfExpired();
                    }
                }
            }
        }
    }
}
