package filters;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.PasswordModel;

public class FilterChain {

    private List<FilterInterface> myFilters = new ArrayList<FilterInterface>();
    private Object target;

    public FilterChain() {
    }

    public void executePreProcessing(String password) {
        FilterInterface filter;

        Iterator filters = myFilters.iterator();
        while (filters.hasNext()) {
            filter = (FilterInterface) filters.next();
            password = filter.executePreProcessing(password);
        }
        ((PasswordModel)target).setPassword(password);
    }
    
    public String executePostProcessing() {
        FilterInterface filter;
        String password = ((PasswordModel)target).getPassword();
        Iterator filters = myFilters.iterator();
        while (filters.hasNext()) {
            filter = (FilterInterface) filters.next();
            password = filter.executePostProcessing(password);
        }
        
        return password;
    }

    public void addFilter(FilterInterface filter) {
        myFilters.add(filter);
    }
    
    public void setTarget(Object target){
      this.target = target;
   }

    public void clearFilters() {
        myFilters.clear();
    }
}
