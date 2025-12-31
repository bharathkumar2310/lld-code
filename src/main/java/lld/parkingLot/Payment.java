package lld.parkingLot;

import java.time.LocalDateTime;

public class Payment {
    private String paymentId;
    private LocalDateTime paymentTime;
    private PaymentType paymentType;
    private Double amount;
    private PaymentStatus status;


    public Payment(String paymentId, LocalDateTime paymentTime, PaymentType paymentType, Double amount, PaymentStatus staus) {
        this.paymentId = paymentId;
        this.paymentTime = paymentTime;
        this.paymentType = paymentType;
        this.amount = amount;
        this.status = status;
    }
}
