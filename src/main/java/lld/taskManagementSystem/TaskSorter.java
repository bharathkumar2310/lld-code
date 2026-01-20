package lld.taskManagementSystem;


import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskSorter {

    public enum SortField {
        NAME, STATUS, PRIORITY, DUEDATE
    }

    public enum SortOrder {
        ASCENDING, DESCENDING
    }

    public List<Task> sortTasks(List<Task> tasks, SortField field, SortOrder order) {
        Comparator<Task> comparator;

        // choose comparator based on field
        switch (field) {
            case NAME:
                comparator = Comparator.comparing(Task::getTaskName, Comparator.nullsLast(String::compareTo));
                break;
            case STATUS:
                comparator = Comparator.comparing(Task::getTaskStatus, Comparator.nullsLast(Enum::compareTo));
                break;
            case PRIORITY:
                comparator = Comparator.comparing(Task::getTaskPriority, Comparator.nullsLast(Enum::compareTo));
                break;
            case DUEDATE:
                comparator = Comparator.comparing(Task::getDueDate, Comparator.nullsLast(LocalDateTime::compareTo));
                break;
            default:
                throw new IllegalArgumentException("Invalid sort field");
        }

        // reverse if descending
        if (order == SortOrder.DESCENDING) {
            comparator = comparator.reversed();
        }

        return tasks.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
