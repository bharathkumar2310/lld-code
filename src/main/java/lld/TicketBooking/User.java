package lld.TicketBooking;

public class User {
    private long UserId;
    private String userName;
    private String email;

    public User(long userId, String email, String userName) {
        UserId = userId;
        this.email = email;
        this.userName = userName;
    }

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        UserId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
