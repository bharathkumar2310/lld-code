package lld.TicketBooking;

import java.util.Random;

public class UserService {

    private BookMyShowApp bookMyShowApp;

    public UserService(BookMyShowApp bookMyShowApp) {
        this.bookMyShowApp = bookMyShowApp;
    }

    public String createUser(String userName, String email) {
        Random randomNo = new Random();
        long userId = randomNo.nextLong();

        if(!bookMyShowApp.getUsers().stream().filter((user) -> user.getEmail().equals(email)).findAny().isEmpty()) {
            throw new RuntimeException("EmailId already exists");
            // thow new custom exception
        }
        User user = new User(userId, userName, email);
        bookMyShowApp.getUsers().add(user);
        return "User" + " " + "username" + " created successfully";

    }
}
