package lld.LibraryManagementApp;

import java.time.LocalDateTime;

public class MemberShipPlanYearly implements MemberShipPlan{

    @Override
    public int calculateAmount() {
        return 4000;
    }

    @Override
    public int maxNoOfBooks() {
        return 15;
    }

    @Override
    public LocalDateTime validTill(LocalDateTime validFrom) {
        return validFrom.plusYears(1);
    }
}
