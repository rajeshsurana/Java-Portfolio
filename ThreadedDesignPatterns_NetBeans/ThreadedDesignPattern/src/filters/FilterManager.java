/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import model.PasswordModel;

/**
 *
 * @author Rajesh Surana
 */
public class FilterManager {
    private FilterChain filterChain;
    
    public FilterManager(Object target){
      filterChain = new FilterChain();
      filterChain.setTarget(target);
    }
    public void setFilter(FilterInterface filter){
       this.filterChain.addFilter(filter);
    }
    public void clearFilters(){
        this.filterChain.clearFilters();
    }
    
    public String execute(String request){
        filterChain.executePreProcessing(request);
        return filterChain.executePostProcessing();
    }
}
