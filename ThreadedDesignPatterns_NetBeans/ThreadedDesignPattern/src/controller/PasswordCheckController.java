/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import filters.FilterInterface;
import filters.FilterManager;
import model.PasswordModel;
import view.PasswordCheckView;

/**
 *
 * @author Rajesh Surana
 */
public class PasswordCheckController {
    private PasswordModel model;
    private PasswordCheckView view;
    private FilterManager fm;
    
    public void startApplication(PasswordModel model, PasswordCheckView view) {
        // View the application's GUI
        this.view = view;
        this.model = model;
        this.view.setVisible(true);
        this.fm = new FilterManager((Object)this.model);
    }
     
    public void setFilters(String[] filter){
        // Remove previously set filters if any
        fm.clearFilters();
        // Set filters selected in form
        try{
            for(int i=0; i<3; i++){
                if(!filter[i].equals("None")){
                    Class<?> c = Class.forName("filters."+filter[i]);
                    FilterInterface filter1 = (FilterInterface)c.newInstance();
                    fm.setFilter(filter1);
                }
            }

        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }catch(Exception e1){
            e1.printStackTrace();
        }
    }
    
    public String execute(String request){
        return fm.execute(request);
    }
}
