package lld.LibraryManagementApp;

import java.time.LocalDateTime;

public class MemberShipPlanMonthly implements MemberShipPlan{
    @Override
    public int calculateAmount() {
        return 500;
    }

    @Override
    public int maxNoOfBooks() {
        return 5;
    }

    @Override
    public LocalDateTime validTill(LocalDateTime validFrom) {
        return validFrom.plusDays(30);
    }
}
