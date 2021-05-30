package edu.coursework.philharmonic.service.cinema.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICinemaService
    @version:    1.0.0
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Cinema;

import java.util.List;

public interface ICinemaService {

    Cinema getById(String id);
    Cinema create(Cinema cinema);
    Cinema update(Cinema cinema);
    Cinema delete(String id);
    List<Cinema> getAll();
}
