package lld.taskManagementSystem;

public class User {
    private Long userId;
    private String userName;
    private String email;
    private String telephoneNo;

    public User(Long userId, String userName, String email, String telephoneNo) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.telephoneNo = telephoneNo;
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

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }
}
