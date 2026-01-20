package lld.taskManagementSystem;

import java.util.List;

public class FilterService {

    private TaskManagementApp taskManagementApp;

    public FilterService(TaskManagementApp taskManagementApp) {
        this.taskManagementApp = taskManagementApp;
    }

//    FilterInterface filter =
//            new FilterAnd(List.of(
//                    new FilterOr(List.of(
//                            new StatusFilter(TaskStatus.ACTIVE),
//                            new StatusFilter(TaskStatus.BLOCKED)
//                    )),
//                    new AssignedToFilter("user1")
//            ));


    public List<Task> filterTasks(FilterInterface filter) {
        //        return taskManagementApp.getTaskMap().values().stream().filter((task ) -> filter.apply(task)).toList();
        return taskManagementApp.getTaskMap().values().stream().filter(filter::apply).toList();
    }
}
