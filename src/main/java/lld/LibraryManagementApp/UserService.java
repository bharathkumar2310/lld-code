package lld.LibraryManagementApp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class UserService {

    private AtomicLong userIdGenerator = new AtomicLong(0);

   private LibManagementApp libManagementApp;
   private static MemeberShipPlanFactory memeberShipPlanFactory = new MemeberShipPlanFactory();


    public UserService(LibManagementApp libManagementApp) {
        this.libManagementApp = libManagementApp;
    }


    public String registerUser(User user) {
        Long userId = userIdGenerator.incrementAndGet();
        user.setUserId(userId);

        libManagementApp.getUsers().put(userId, user);

        Membership membership = new Membership();
        membership.setStatus(MemberShipStatus.PENDING_PAYMENT);

        libManagementApp.getUserMemberships().put(userId, membership);

        return "User registered successfully";
    }


    public String loginUser(String userName, String password) {
        List<User> users = libManagementApp.getUsers().values().stream().toList();
        User user = users.stream().filter((user1) -> user1.getUserName().equals(userName) && user1.getPassword().equals(password)).findFirst().orElse(null);
        if(user == null) {
            throw new RuntimeException("User not found");
        }
        return "User loggedIn Successfully";
    }

    public void activateMembership(Long userId, MemberShipPlan plan) {
        Membership membership =
                libManagementApp.getUserMemberships().get(userId);

        membership.setStatus(MemberShipStatus.ACTIVE);

        LocalDateTime now = LocalDateTime.now();
        membership.setValidFrom(now);
        membership.setValidTo(plan.validTill(now));
        membership.setMaxBooks(plan.maxNoOfBooks());
    }


    public void setPaymentFailed(Long userId) {
        Membership membership =
                libManagementApp.getUserMemberships().get(userId);

        membership.setStatus(MemberShipStatus.PENDING_PAYMENT);
    }



}
