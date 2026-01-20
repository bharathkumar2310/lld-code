package lld.LibraryManagementApp;

import java.time.LocalDateTime;

public class PaymentRecord {
    private Long userId;
    private int amount;
    private PaymentType paymentType;
    private boolean success;
    private LocalDateTime timestamp;

    public PaymentRecord(Long userId, int amount, PaymentType paymentType, boolean success) {
        this.userId = userId;
        this.amount = amount;
        this.paymentType = paymentType;
        this.success = success;
        this.timestamp = LocalDateTime.now();
    }
}
