package lld.taskManagementSystem;

import java.util.List;

public class FilterAnd implements FilterInterface{

    private List<FilterInterface> filterInterfaces;

    public FilterAnd(List<FilterInterface> filterInterfaces) {
        this.filterInterfaces = filterInterfaces;
    }

    @Override
    public boolean apply(Task task) {
        for(FilterInterface filterInterface : filterInterfaces) {
            if(!filterInterface.apply(task)) {
                return false;
            }
        }
        return true;
    }
}
