package lld.TicketBooking;

import java.util.List;

public class Booking {
    private User user;
    private long bookingId;
    private Show show;
    private List<ShowSeat> seats;
    private BookingStatus bookingStatus;
    private int amount;


    public Booking(User user, long bookingId, Show show,  List<ShowSeat> seats,  int amount) {
        this.user = user;
        this.bookingId = bookingId;
        this.show = show;
        this.seats = seats;
        this.bookingStatus = BookingStatus.INITIATED;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<ShowSeat> getShowSeats() {
        return seats;
    }

    public void setShowSeats(List<ShowSeat> seats) {
        this.seats = seats;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
