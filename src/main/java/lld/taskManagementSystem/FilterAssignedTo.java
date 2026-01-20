package lld.taskManagementSystem;

public class FilterAssignedTo  implements FilterInterface{

    private String assignedTo;

    public FilterAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public boolean apply(Task task) {
        return task.getAssignedTo().equals(assignedTo);
    }
}
