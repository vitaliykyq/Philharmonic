package edu.coursework.philharmonic.service.cinema.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.HangGlider;

import java.util.List;

public interface ICinemaService {

    HangGlider getById(String id);
    HangGlider create(HangGlider hangGlider);
    HangGlider update(HangGlider hangGlider);
    HangGlider delete(String id);
    List<HangGlider> getAll();
}
