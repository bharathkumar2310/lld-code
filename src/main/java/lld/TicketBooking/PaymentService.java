package lld.TicketBooking;


public class PaymentService {

    private PaymentStrategyFactory paymentStrategyFactory;

    public boolean pay(Booking booking, PaymentType paymentType) {
        PaymentStrategy paymentStrategy = paymentStrategyFactory.getPaymentService(paymentType);
        boolean isPaid = paymentStrategy.pay(booking);
        if(isPaid) {
            booking.setBookingStatus(BookingStatus.CONFIRMED);
            return true;
        }

        return false;
    }
}
