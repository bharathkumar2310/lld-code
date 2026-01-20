package lld.LibraryManagementApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibManagementApp {

    private Map<Long, User> users;
    private Map<Long, Membership>userMemberships;
    private Map<Long, List<PaymentRecord>>userTransactionRecords;

    public LibManagementApp() {
        this.users = new HashMap<>();
        this.userMemberships = new HashMap<>();
    }

    public Map<Long, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Long, User> users) {
        this.users = users;
    }

    public Map<Long, Membership> getUserMemberships() {
        return userMemberships;
    }

    public void setUserMemberships(Map<Long, Membership> userMemberships) {
        this.userMemberships = userMemberships;
    }

    public Map<Long, List<PaymentRecord>> getUserTransactionRecords() {
        return userTransactionRecords;
    }

    public void setUserTransactionRecords(Map<Long, List<PaymentRecord>> userTransactionRecords) {
        this.userTransactionRecords = userTransactionRecords;
    }
}
