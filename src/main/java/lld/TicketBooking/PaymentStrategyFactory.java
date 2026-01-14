package lld.TicketBooking;


public class PaymentStrategyFactory {

    public  PaymentStrategy getPaymentService(PaymentType paymentType) {
        if(paymentType == PaymentType.CREDIT) {
            return new PaymentStrategyCredit();
        }
        else if(paymentType == PaymentType.DEBIT) {
            return new PaymentStrategyDebit();
        }
        return null;
    }
}
