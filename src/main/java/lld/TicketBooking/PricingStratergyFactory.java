package lld.TicketBooking;

public class PricingStratergyFactory {

    public PricingStratergy selectPricingStatergy(SeatType seatType) {
        if(seatType == SeatType.NORMAL) {
            return new PricingStratergyNormal();
        }
        else if(seatType == SeatType.PREMIUM) {
            return new PricingStratergyPremium();
        }
        return null;
    }
}
