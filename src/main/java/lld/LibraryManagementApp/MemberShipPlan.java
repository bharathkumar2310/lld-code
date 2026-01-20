package lld.LibraryManagementApp;

import java.time.LocalDateTime;

public interface MemberShipPlan {
    public int calculateAmount();
    public int maxNoOfBooks();
    public LocalDateTime validTill(LocalDateTime validFrom);
}
