package lld.taskManagementSystem;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.atomic.AtomicLong;

public class UserService {

    private TaskManagementApp taskManagementApp;
    private static final AtomicLong ID_GENERATOR = new AtomicLong(1);

    public UserService(TaskManagementApp taskManagementApp) {
        this.taskManagementApp = taskManagementApp;
    }

    public String createUser(String userName, String email, String telephoneNo) {

        if (userName == null || email == null || telephoneNo == null) {
            throw new RuntimeException("Required fields missing");
        }

        for (User u : taskManagementApp.getUserMap().values()) {
            if (u.getEmail().equals(email)) {
                throw new RuntimeException("Email already exists");
            }
        }

        Long userId = ID_GENERATOR.getAndIncrement();
        User user = new User(userId, userName, email, telephoneNo);
        taskManagementApp.getUserMap().put(userId, user);

        return "User created successfully";
    }

    public String deleteUser(Long userId) {
        if (!taskManagementApp.getUserMap().containsKey(userId)) {
            return "User not found";
        }
        taskManagementApp.getUserMap().remove(userId);
        return "User deleted successfully";
    }

    public String updateUser(User changedUser, Long userId) {

        User user = taskManagementApp.getUserMap().get(userId);
        if (user == null) {
            return "User not found";
        }

        if (changedUser.getTelephoneNo() != null) {
            user.setTelephoneNo(changedUser.getTelephoneNo());
        }

        if (changedUser.getEmail() != null) {
            for (User u : taskManagementApp.getUserMap().values()) {
                if (u.getEmail().equals(changedUser.getEmail())) {
                    throw new RuntimeException("Email already exists");
                }
            }
            user.setEmail(changedUser.getEmail());
        }

        return "User updated successfully";
    }

    public List<User> viewAllUsers() {
        return new ArrayList<>(taskManagementApp.getUserMap().values());
    }
}

//AtomicLong is used to generate unique, thread-safe IDs without collisions.

//1️⃣ Soft Delete (Mention only)
//“In a real system, I would soft-delete users to avoid breaking task assignments.”
//No code needed.

//2️⃣ Task Ownership Handling (Mention only)
//“When a user is deleted, tasks can be reassigned or marked unassigned.”
//Again, do not implement.

//        3️⃣ Authorization (Mention only)
//“Authorization can be handled via a separate service or middleware.”
//You already handled this correctly by not coding it.

//4️⃣ Pagination (Mention only)
//“For large user sets, pagination can be added.”
//No implementation needed.
