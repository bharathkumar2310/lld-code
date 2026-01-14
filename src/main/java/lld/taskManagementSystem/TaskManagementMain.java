package lld.taskManagementSystem;

public class TaskManagementMain {

    public static void main(String[] args) {

        TaskManagementApp taskManagementApp = new TaskManagementApp();

        UserService userService = new UserService(taskManagementApp);
        userService.createUser("Ram" , "ram@gmail.com");
        userService.createUser("Abc" , "abc@gmail.com");
        userService.createUser("Ghi" , "ghi@gmail.com");
        userService.createUser("Poi" , "poi@gmail.com");


        // create Task

        Task task





    }
}
