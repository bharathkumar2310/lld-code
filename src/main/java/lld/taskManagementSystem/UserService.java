package lld.taskManagementSystem;

import java.util.Random;

public class UserService {

    private TaskManagementApp taskManagementApp;

    public UserService(TaskManagementApp taskManagementApp) {
        this.taskManagementApp = taskManagementApp;
    }

    public String createUser(String userName, String email ) {
        if(userName == null || email == null) {
            throw new RuntimeException("Required Fields Missing");
        }
        if( taskManagementApp.getUserMap().containsKey(email)) {
            throw new RuntimeException("EmailId already exists");
        }
        Random random = new Random();
        long userId = Math.abs(random.nextLong());
        User user = new User(userId, userName, email);
        taskManagementApp.getUserMap().put(email, user);

        return userName  + " created successfully";
    }

    // updateUser
    //deleteUser

}
