package lld.TicketBooking;


import java.util.List;
import java.util.Random;

public class BookingServie {
    private  BookMyShowApp bookMyShowApp;
    private PricingStratergyFactory pricingStratergyFactory;
    private PaymentService paymentService;

    public BookingServie(BookMyShowApp bookMyShowApp,PricingStratergyFactory pricingStratergyFactory,
                         PaymentService paymentService) {
        this.bookMyShowApp = bookMyShowApp;
        this.pricingStratergyFactory = pricingStratergyFactory;
        this.paymentService = paymentService;
    }


    public Booking bookShow(User user, Show show, List<ShowSeat> seats) {
        for(ShowSeat seat : seats) {
            if(!seat.lockSeat()) {
                unLockAllSeats(seats);
                throw new RuntimeException("One of the seats is locked");

            }

        }
        int amountToBePaid = 0;
        for(ShowSeat seat : seats) {
            PricingStratergy pricingStratergy =  pricingStratergyFactory.selectPricingStatergy(seat.getSeat().getSeatType());
            amountToBePaid += pricingStratergy.calculateAmount();
        }
        Random random = new Random();
        long bookingId = random.nextLong();
        Booking booking = new Booking(user,bookingId, show, seats, amountToBePaid);
        return booking;
    }


    public void unLockAllSeats(List<ShowSeat> seats)  {
        for(ShowSeat seat : seats) {
            seat.unLockSeat();
        }
    }


    public Booking payBooking(Booking booking, PaymentType paymentType) {
        boolean isPaid = paymentService.pay(booking,paymentType);
        List<ShowSeat>showSeats = booking.getShowSeats();

        if (isPaid) {
            for (ShowSeat seat : showSeats) {
                seat.book();
            }
            booking.setBookingStatus(BookingStatus.CONFIRMED);
        } else {
            for (ShowSeat seat : showSeats) {
                seat.unLockSeat();
            }
            booking.setBookingStatus(BookingStatus.CANCELLED);
        }
        return booking;

    }
}
