package lld.TicketBooking;

import java.time.LocalDateTime;
import java.util.List;

public class ShowSeat {
    private Seat seat;
    private Show show;
    private SeatStatus seatStatus;
    private LocalDateTime lockedTime;

    private static long LOCK_TIMEOUT_MINUTES = 5;

    public ShowSeat(Seat seat, SeatStatus seatStatus) {
        this.seat = seat;
        this.seatStatus = seatStatus;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public LocalDateTime getLockedTime() {
        return lockedTime;
    }

    public void setLockedTime(LocalDateTime lockedTime) {
        this.lockedTime = lockedTime;
    }



    public synchronized boolean lockSeat() {
        if(this.seatStatus == SeatStatus.AVAILABLE) {
            this.seatStatus = SeatStatus.LOCKED;
            this.lockedTime = LocalDateTime.now();
            return true;
        }
        return false;

    }

    public synchronized boolean unLockSeat() {
        this.seatStatus = SeatStatus.AVAILABLE;
        this.lockedTime = null;
        return true;
    }

   public synchronized boolean book() {
       if (this.seatStatus == SeatStatus.LOCKED) {
           this.seatStatus = SeatStatus.BOOKED;
           this.lockedTime = null;
           return true;
       }
       return false;
   }

    public synchronized boolean isLockExpired() {
        if (seatStatus != SeatStatus.LOCKED) return false;

        return lockedTime.plusMinutes(LOCK_TIMEOUT_MINUTES)
                .isBefore(LocalDateTime.now());
    }

    public synchronized void unlockIfExpired() {
        if (isLockExpired()) {
            seatStatus = SeatStatus.AVAILABLE;
            lockedTime = null;
        }
    }


}
