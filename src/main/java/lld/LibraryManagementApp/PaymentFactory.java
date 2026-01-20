package lld.LibraryManagementApp;

public class PaymentFactory {

    public Payment getPaymentObject(PaymentType paymentType) {
        if(paymentType == PaymentType.CREDIT) {
            return new PaymentCredit();
        }
        if(paymentType == PaymentType.DEBIT) {
            return new PaymentDebit();
        }
        throw new RuntimeException("Illegal Payment Type");

    }
}
