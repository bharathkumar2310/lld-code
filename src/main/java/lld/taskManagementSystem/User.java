package lld.taskManagementSystem;

public class User {
    private Long userId;
    private String userName;
    private String email;

    public User(Long userId, String email, String userName) {
        this. userId = userId;
        this.email = email;
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
