package lld.taskManagementSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TaskManagementApp {
    private Map<Long, User> userMap;
    private Map<Long, Task> taskMap;
    private Map<TaskStatus, Set<TaskStatus>> allowedTransitions = Map.of(
            TaskStatus.NEW, Set.of(TaskStatus.ACTIVE),
            TaskStatus.ACTIVE, Set.of(TaskStatus.RESOLVED, TaskStatus.BLOCKED),
            TaskStatus.BLOCKED, Set.of(TaskStatus.ACTIVE),
            TaskStatus.RESOLVED, Set.of(TaskStatus.ACTIVE) // reopen allowed
    );
    private Map<Long, List<TaskHistory>> taskHistory;



    public TaskManagementApp() {
        this.userMap = new HashMap<>();
        this.taskMap = new HashMap<>();
        this.taskHistory = new HashMap<>();
    }

    public Map<Long, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<Long, User> userMap) {
        this.userMap = userMap;
    }

    public Map<Long, Task> getTaskMap() {
        return taskMap;
    }

    public void setTaskMap(Map<Long, Task> taskMap) {
        this.taskMap = taskMap;
    }

    public Map<TaskStatus, Set<TaskStatus>> getAllowedTransitions() {
        return allowedTransitions;
    }

    public void setAllowedTransitions(Map<TaskStatus, Set<TaskStatus>> allowedTransitions) {
        this.allowedTransitions = allowedTransitions;
    }

    public Map<Long, List<TaskHistory>> getTaskHistory() {
        return taskHistory;
    }

    public void setTaskHistory(Map<Long, List<TaskHistory>> taskHistory) {
        this.taskHistory = taskHistory;
    }
}
