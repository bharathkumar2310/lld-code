package lld.LibraryManagementApp;

public class PaymentDebit implements Payment{
    @Override
    public boolean pay(int amount) {
        return true;
    }
}
