package edu.coursework.philharmonic.service.theater.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Civil;

import java.util.List;

public interface ITheaterService {

    Civil getById(String id);
    Civil create(Civil civil);
    Civil update(Civil civil);
    Civil delete(String id);
    List<Civil> getAll();
}
