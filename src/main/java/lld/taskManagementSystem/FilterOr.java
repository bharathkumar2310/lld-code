package lld.taskManagementSystem;

import java.util.List;

public class FilterOr implements FilterInterface{
    private List<FilterInterface>filterInterfaces;

    public FilterOr(List<FilterInterface> filterInterfaces) {
        this.filterInterfaces = filterInterfaces;
    }

    @Override
    public boolean apply(Task task) {
        for(FilterInterface filterInterface : filterInterfaces) {
            if(filterInterface.apply(task)) {
                return true;
            }
        }
        return false;
    }
}
