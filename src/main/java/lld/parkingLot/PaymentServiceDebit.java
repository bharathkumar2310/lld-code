package lld.parkingLot;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentServiceDebit implements PaymentService{

    private PricingStrategy pricingStrategy;

    public PaymentServiceDebit(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    @Override
    public boolean pay(Ticket ticket) {
        double amount = pricingStrategy.calculateFee(ticket);
        Payment payment = new Payment(UUID.randomUUID().toString(), LocalDateTime.now(),PaymentType.DEBIT, amount, PaymentStatus.SUCCESS);
        PaymentList.paymentHistory.add(payment);
        System.out.println("Paid amount" + amount + "Successfully via Debit");
        return true;

    }
}
