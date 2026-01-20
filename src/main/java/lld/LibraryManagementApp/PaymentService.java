package lld.LibraryManagementApp;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {

    private PaymentFactory paymentFactory;
    private LibManagementApp libManagementApp;

    public PaymentService(PaymentFactory paymentFactory, LibManagementApp libManagementApp) {
        this.paymentFactory = paymentFactory;
        this.libManagementApp = libManagementApp;
    }

    public boolean processPayment(Long userId, int amount , PaymentType paymentType){
        Payment payment = paymentFactory.getPaymentObject(paymentType);
        boolean isPaid = payment.pay(amount);
        PaymentRecord record = new PaymentRecord(userId, amount, paymentType,isPaid);
        List<PaymentRecord> paymentRecordList = libManagementApp.getUserTransactionRecords().get(userId);
        if(paymentRecordList == null) {
            paymentRecordList = new ArrayList<>();
        }
        paymentRecordList.add(record);
        libManagementApp.getUserTransactionRecords().put(userId, paymentRecordList);
        return isPaid;

    }

    public boolean refundPayment(Long userId, int amount, PaymentType paymentType) {
        return true;
    }


}
