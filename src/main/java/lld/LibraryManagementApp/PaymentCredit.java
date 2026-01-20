package lld.LibraryManagementApp;

public class PaymentCredit implements Payment{

    @Override
    public boolean pay(int amount) {
        return true;
    }
}
