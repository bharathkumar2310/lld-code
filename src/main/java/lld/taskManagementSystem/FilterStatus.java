package lld.taskManagementSystem;

import java.util.List;

public class FilterStatus implements FilterInterface{

    private TaskStatus taskStatus;


    public FilterStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public boolean apply(Task task) {
       return task.getTaskStatus() == taskStatus;
    }
}
