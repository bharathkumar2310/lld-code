package lld.taskManagementSystem;

public class TaskManagementMain {

    public static void main(String[] args) {

        TaskManagementApp taskManagementApp = new TaskManagementApp();

        UserService userService = new UserService(taskManagementApp);
        userService.createUser("Ram" , "ram@gmail.com", "9876543210");
        userService.createUser("Abc" , "abc@gmail.com", "9876543211");
        userService.createUser("Ghi" , "ghi@gmail.com", "9876543212");
        userService.createUser("Poi" , "poi@gmail.com", "9876543213");


        // create Task






    }
}
