package edu.coursework.philharmonic.service.tribune.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Equipment;

import java.util.List;

public interface ITribuneService {

    Equipment getById(String id);
    Equipment create(Equipment equipment);
    Equipment update(Equipment equipment);
    Equipment delete(String id);
    List<Equipment> getAll();
}
