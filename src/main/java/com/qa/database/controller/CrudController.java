package com.qa.database.controller;

import java.util.List;

/**
 * Create, Read, Update and Delete controller.
 * Takes in inputs for each action to be sent to a service class
 * this is the basic crud model
 */
public interface CrudController<T> {
    
    List<T> readAll();
     
    T create();
     
    T update();
     
    void delete();

}
