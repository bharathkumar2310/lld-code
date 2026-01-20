package lld.taskManagementSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

// for each and every function in tasks we need to have a authorization check
public class TaskService {

    private TaskManagementApp taskManagementApp;

    public TaskService(TaskManagementApp taskManagementApp) {
        this.taskManagementApp = taskManagementApp;
    }

    private static AtomicLong taskIdGenerator = new AtomicLong(0);

    public String createTask(TaskRequest taskRequest) {
        String taskName = taskRequest.getTaskName();
        if(taskName == null) {
            throw new RuntimeException("TaskName cannot be empty");
        }
        Long taskId = taskIdGenerator.incrementAndGet();
        Task taskToCreate = new Task(taskId, taskName);
        taskToCreate.setCreatedBy(taskRequest.getCreatedBy());
        LocalDateTime createdDate = LocalDateTime.now();
        taskToCreate.setCreatedDate(createdDate);
        if (!taskManagementApp.getUserMap().containsKey(taskRequest.getAssignedTo())) {
            throw new RuntimeException("Assigned user does not exist");
        }
        taskToCreate.setAssignedTo(taskRequest.getAssignedTo());
        taskToCreate.setDescription(taskRequest.getDescription());
        LocalDateTime dueDate = taskRequest.getDueDate();

        if (dueDate != null && dueDate.isBefore(createdDate)) {
            throw new RuntimeException("Due date cannot be before created date");
        }

        taskToCreate.setDueDate(taskRequest.getDueDate());
        taskToCreate.setTaskPriority(taskRequest.getTaskPriority());
        taskToCreate.setTaskStatus(TaskStatus.NEW);



        taskManagementApp.getTaskMap().put(taskId, taskToCreate);
        TaskHistory taskHistory = createTaskHistory(taskToCreate);
        List<TaskHistory> taskHistoryList = new ArrayList<>();
        taskHistoryList.add(taskHistory);
        taskManagementApp.getTaskHistory().put(taskId,taskHistoryList);
        return "Task Created Successfully";

    }


    public String updateTask(ModifyTaskRequest modifyTaskRequest, Long taskId, User user) {

        Task task = taskManagementApp.getTaskMap().get(taskId);
        if (task == null) {
            throw new RuntimeException("Task not found");
        }

        // Optional authorization guard
        if (!task.getAssignedTo().equals(user.getUserName())) {
            throw new RuntimeException("Unauthorized to update task");
        }

        if (modifyTaskRequest.getTaskName() != null) {
            task.setTaskName(modifyTaskRequest.getTaskName());
        }

        if (modifyTaskRequest.getDescription() != null) {
            task.setDescription(modifyTaskRequest.getDescription());
        }

        if (modifyTaskRequest.getTaskPriority() != null) {
            task.setTaskPriority(modifyTaskRequest.getTaskPriority());
        }

        if (modifyTaskRequest.getTaskStatus() != null) {
            validateTransition(task.getTaskStatus(), modifyTaskRequest.getTaskStatus());
            task.setTaskStatus(modifyTaskRequest.getTaskStatus());
        }

        if (modifyTaskRequest.getAssignedTo() != null) {
            if (!taskManagementApp.getUserMap().containsKey(modifyTaskRequest.getAssignedTo())) {
                throw new RuntimeException("Assigned user does not exist");
            }
            task.setAssignedTo(modifyTaskRequest.getAssignedTo());
        }

        LocalDateTime dueDate = modifyTaskRequest.getDueDate();
        if (dueDate != null) {
            if (dueDate.isBefore(task.getCreatedDate())) {
                throw new RuntimeException("Due date cannot be before created date");
            }
            task.setDueDate(dueDate);
        }

        task.setLastModifiedBy(user.getUserName());
        task.setLastModifiedTime(LocalDateTime.now());
        TaskHistory taskHistory = createTaskHistory(task);
        List<TaskHistory> taskHistoryList = taskManagementApp.getTaskHistory().get(taskId);
        taskHistoryList.add(taskHistory);
        return "Task modified successfully";
    }

    private void validateTransition(TaskStatus from, TaskStatus to) {
        if (!taskManagementApp
                .getAllowedTransitions()
                .getOrDefault(from, Set.of())
                .contains(to)) {
            throw new RuntimeException("Invalid state transition");
        }
    }



    // instaed of deleting fully we can just have isActive flag and set to false
    private String deleteTask(Long taskId, User user) {

        Task task = taskManagementApp.getTaskMap().get(taskId);
        if (task == null) {
            throw new RuntimeException("Task not found");
        }

        // minimal authorization
        if (!task.getAssignedTo().equals(user.getUserName())) {
            throw new RuntimeException("Unauthorized to delete task");
        }

        taskManagementApp.getTaskMap().remove(taskId);
        return "Task deleted successfully";
    }


    private TaskHistory createTaskHistory(Task taskToCreate) {
        TaskHistory taskHistory = new TaskHistory();
        taskHistory.setTaskName(taskToCreate.getTaskName());
        taskHistory.setTaskPriority(taskToCreate.getTaskPriority());
        taskHistory.setTaskStatus(taskToCreate.getTaskStatus());
        taskHistory.setDescription(taskToCreate.getDescription());
        taskHistory.setDueDate(taskToCreate.getDueDate());
        taskHistory.setAssignedTo(taskToCreate.getAssignedTo());
        taskHistory.setModifiedBy(taskToCreate.getLastModifiedBy() == null ? taskToCreate.getCreatedBy(): taskToCreate.getLastModifiedBy());
        taskHistory.setModifiedAt(taskToCreate.getLastModifiedTime() == null ? taskToCreate.getCreatedDate() : taskToCreate.getLastModifiedTime());
        return taskHistory;
    }



}
