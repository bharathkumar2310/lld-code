package lld.taskManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class TaskManagementApp {
    private Map<String, User> userMap;
    private Map<String, Task> taskMap;

    public TaskManagementApp() {
        this.userMap = new HashMap<>();
        this.taskMap = new HashMap<>();
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Map<String, Task> getTaskMap() {
        return taskMap;
    }

    public void setTaskMap(Map<String, Task> taskMap) {
        this.taskMap = taskMap;
    }
}
