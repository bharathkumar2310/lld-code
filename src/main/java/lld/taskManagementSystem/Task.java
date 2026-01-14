package lld.taskManagementSystem;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
    private final String taskId;
    private String taskName;
    private String description;
    private String createdBy;
    private LocalDateTime createdDate;
    private String assignedTo;
    private LocalDateTime dueDate;
    private TaskPriority taskPriority;
    private TaskStatus taskStatus;

    private Task(TaskBuilder builder) {
        this.taskId = builder.taskId;
        this.taskName = builder.taskName;
        this.description = builder.description;
        this.createdBy = builder.createdBy;
        this.createdDate = builder.createdDate;
        this.assignedTo = builder.assignedTo;
        this.dueDate = builder.dueDate;
        this.taskPriority = builder.taskPriority;
        this.taskStatus = builder.taskStatus;
    }

    // Thread-safe rename
    public synchronized void renameTask(String newName) {
        if (newName == null || newName.isEmpty()) {
            throw new IllegalArgumentException("Task name cannot be empty");
        }
        this.taskName = newName;
    }

    // Optional: make other setters synchronized for thread safety
    public synchronized void updateDescription(String description) {
        this.description = description;
    }

    public synchronized void updateAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public synchronized void updateTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public synchronized void updateTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    // Getters
    public String getTaskId() { return taskId; }
    public String getTaskName() { return taskName; }
    public String getDescription() { return description; }
    public String getCreatedBy() { return createdBy; }
    public LocalDateTime getCreatedDate() { return createdDate; }
    public String getAssignedTo() { return assignedTo; }
    public LocalDateTime getDueDate() { return dueDate; }
    public TaskPriority getTaskPriority() { return taskPriority; }
    public TaskStatus getTaskStatus() { return taskStatus; }

    // Builder
    public static class TaskBuilder {
        private String taskId;
        private String taskName;
        private String description;
        private String createdBy;
        private LocalDateTime createdDate;
        private String assignedTo;
        private LocalDateTime dueDate;
        private TaskPriority taskPriority;
        private TaskStatus taskStatus;

        public TaskBuilder(String taskName) {
            this.taskId = UUID.randomUUID().toString();
            this.taskName = taskName;
        }

        public TaskBuilder description(String description) {
            this.description = description;
            return this;
        }

        public TaskBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public TaskBuilder assignedTo(String assignedTo) {
            this.assignedTo = assignedTo;
            return this;
        }

        public TaskBuilder dueDate(LocalDateTime dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public TaskBuilder taskPriority(TaskPriority taskPriority) {
            this.taskPriority = taskPriority;
            return this;
        }

        public TaskBuilder taskStatus(TaskStatus taskStatus) {
            this.taskStatus = taskStatus;
            return this;
        }

        // Optional: allow custom creation date
        public TaskBuilder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Task build() {
            if (taskName == null || taskName.isEmpty()) {
                throw new IllegalStateException("Task name is mandatory");
            }
            if (createdDate == null) {
                this.createdDate = LocalDateTime.now();
            }
            return new Task(this);
        }
    }
}
