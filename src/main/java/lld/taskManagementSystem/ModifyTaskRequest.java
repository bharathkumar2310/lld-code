package lld.taskManagementSystem;

import java.time.LocalDateTime;

public class ModifyTaskRequest {
    private String taskName;
    private String description;
    private String assignedTo;//should be in User list
    private LocalDateTime dueDate; // should be after createdDate
    private TaskPriority taskPriority;
    private TaskStatus taskStatus;// can show valid translations from one state to another invalid translation should not happen


    public ModifyTaskRequest(String taskName, String description, String assignedTo, LocalDateTime dueDate, TaskPriority taskPriority, TaskStatus taskStatus) {
        this.taskName = taskName;
        this.description = description;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.taskPriority = taskPriority;
        this.taskStatus = taskStatus;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}
