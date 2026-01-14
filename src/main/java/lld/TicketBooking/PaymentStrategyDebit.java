package lld.TicketBooking;

import lld.parkingLot.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentStrategyDebit implements PaymentStrategy {



    @Override
    public boolean pay(Booking booking) {

        return true;

    }
}
