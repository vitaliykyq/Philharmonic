package edu.coursework.philharmonic.service.theater.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ITheaterService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Theater;

import java.util.List;

public interface ITheaterService {

    Theater getById(String id);
    Theater create(Theater theater);
    Theater update(Theater theater);
    Theater delete(String id);
    List<Theater> getAll();
}
