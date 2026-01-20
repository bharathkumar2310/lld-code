“Based on my initial understanding, there are two main actors: User and Librarian.”

“The system should allow a librarian to:

      – add, view, update, and delete books
      – manage users
      – search and issue books requested by users
      – update book return details”

“The system should allow a user to:

      – register and pay for membership
      – log in
      – search for books
      – request issuing of books
      – pay fines”

“Additionally, the system should calculate fines for overdue books.”

“Books will be managed as metadata with physical copies tracked separately.”

“Does this align with what you’re expecting?”
    













1️⃣ Core Actors (Who uses the system?)
1. Librarian (Admin role)

        Manages books
        Manages users
        Controls issuing, returns, fines

2. Library User (Member)

       Searches books
       Borrows and returns books
       Pays fines

2️⃣ Functional Requirements (What system should do)
📚 Book Management

        Add a new book
        Update book details
        Remove a book
        Maintain multiple copies of the same book
        Track book availability status
        
                AVAILABLE
                ISSUED
                RESERVED
                LOST

        Book details
        
        ISBN
        Title
        Author(s)
        Publisher
        Category / Genre
        Language
        Publication year
        Rack / Shelf location

👤 User Management
Librarian

        Register librarians
        Assign roles/permissions
        Users (Members)
        Register users
        Activate / deactivate members
        Track borrowed books per user

Restrict issuing if:

      Fine exceeds limit

Max books already issued

🔍 Search & Filter (Important for interviews)

Both Librarian & User can:
        
        Search by:
        Title
        Author
        ISBN
        Category

        Filter by:
        
        Availability
        Language
        Publication year
        Difference


Librarian can see:

        Total copies
        
        Issued copies
        
        User who borrowed

User can see:

     Availability only

📦 Book Issue & Return

Issue book to user

        Set due date
        Return book
        Auto-update availability
Prevent issuing if:

        Book unavailable
        User exceeds limit

💰 Pricing & Fine Calculation

        Daily fine amount (configurable)
        Grace period (optional)
        Fine calculated based on:
        fine = overdue_days × per_day_fine
        
        
        Librarian can override fine

User can view fine history

💳 Payment (Optional but good for LLD)

            Pay fine via:
            
            Cash
            
            Card
            
            Online
            
            Track payment status

📄 Notifications

        Due date reminder
        
        Overdue notification
        
        Fine notification


---------------------------------------------------------------------------------------


public class User {

      private Long userId;
      private String userName;
      private String password;
      private String email;
}


public class UserService {

    private LibManagementApp libManagementApp;


    1. public String registerUser(User user) {

    }

    2. public String loginUser(String userName, String password) {
    }

    3. public void activateMembership(Long userId, MemberShipPlan plan) {
       
    }

    4. public void setPaymentFailed(Long userId) {
        
    }

}


public class Membership {

      Long userId;
      MembershipType type;
      MemberShipStatus status;
      LocalDateTime validFrom;
      LocalDateTime validTo;
      int maxBooks;
}

public enum MembershipType {

      One_Month, Yearly, LifeTime
}

public enum MemberShipStatus {

      PENDING_PAYMENT,
      ACTIVE,
      EXPIRED,
      SUSPENDED
}


public interface MemebrShipPlan {

    public int calculateAmount();  
    public int maxNoOfBooks();
    public LocalDateTime validTill(LocalDateTime validFrom);
}

------------------------------------------------------------------
**Here for MemberShipPlan we are using strtaegy + factory Pattern**
-------------------------------------------------------------------

public class MemberShipPlanYearly implements MemebrShipPlan
public class MemberShipPlanMonthly implements MemebrShipPlan
public class MemberShipLifeTime implements MemebrShipPlan

public class MemeberShipPlanFactory {

    private MemberShipPlanMonthly memebrShipPlanMonthly;
    private  MemberShipPlanYearly memberShipPlanYearly;

    1. public MemberShipPlan getMemberShipObject(MembershipType membershipType) {
    }
}

public class UserManagementFacade {

    private UserService userService;
    private MemeberShipPlanFactory memeberShipPlanFactory;
    private PaymentFactory paymentFactory;
    private LibManagementApp libManagementApp;

    1. public String registerUser(User user) {
    }

    2. public String loginUser(String userName, String password) {
    }

    3. public boolean activateUser(Long userId, MembershipType membershipType, PaymentType paymentType) {

    }

}

------------------------------------------------------------------
**Here for Payment we are using strtaegy + factory Pattern**
-------------------------------------------------------------------

public enum PaymentType {

      CREDIT, DEBIT
}


public interface Payment {

      boolean pay(int amount);
}

public class PaymentCredit implements Payment
public class PaymentDebit implements Payment

package lld.LibraryManagementApp;

public class PaymentFactory {

    1. public Payment getPaymentObject(PaymentType paymentType) {

    }
}

package lld.LibraryManagementApp;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {

    private PaymentFactory paymentFactory;
    private LibManagementApp libManagementApp;


    1.public boolean processPayment(Long userId, int amount , PaymentType paymentType){

    }

    2. public boolean refundPayment(Long userId, int amount, PaymentType paymentType) {
    }

}

public class PaymentRecord {

      private Long userId;
      private int amount;
      private PaymentType paymentType;
      private boolean success;
      private LocalDateTime timestamp;
}



------------------------------------------------------------------------------------------------------------------------------------
If we want payment tracking etc we can create a PaymentService class and inside that we can create various methods related to payment
------------------------------------------------------------------------------------------------------------------------------------



