package lld.TicketBooking;

import lld.parkingLot.*;

public class PaymentStrategyCredit implements PaymentStrategy {
    private PricingStrategy pricingStrategy;


    @Override
    public boolean pay(Booking booking) {
        return true;
    }
}
