package lld.parkingLot;

public class PaymentServiceFactory {

    public static PaymentService getPaymentService(PaymentType paymentType, PricingStrategy pricingStrategy) {
        if(paymentType == PaymentType.UPI) {
            return new PaymentServiceUPI(pricingStrategy);
        }
        else if(paymentType == PaymentType.DEBIT) {
            return new PaymentServiceDebit(pricingStrategy);
        }
        return null;
    }
}
