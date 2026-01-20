package lld.LibraryManagementApp.Facades;

import lld.LibraryManagementApp.*;

import java.time.LocalDateTime;

public class UserManagementFacade {

    private UserService userService;
    private MemeberShipPlanFactory memeberShipPlanFactory;
    private PaymentService paymentService;





    public String registerUser(User user) {
        return userService.registerUser(user);
    }

    public String loginUser(String userName, String password) {
        return userService.loginUser(userName, password);
    }

    public boolean activateUser(Long userId, MembershipType membershipType, PaymentType paymentType) {
        MemberShipPlan membershipPlan = memeberShipPlanFactory.getMemberShipObject(membershipType);
        if (membershipPlan == null) {
            // handle invalid membership type
            return false;
        }

        int amount = membershipPlan.calculateAmount();

        boolean isPaid = paymentService.processPayment(userId, amount, paymentType);
        if (isPaid) {
            try {
                userService.activateMembership(userId, membershipPlan);
            } catch (Exception e) {
                paymentService.refundPayment(userId, amount, paymentType);
                userService.setPaymentFailed(userId);
                return false;
            }
        } else {
            userService.setPaymentFailed(userId);
        }

        return isPaid;
    }


}
