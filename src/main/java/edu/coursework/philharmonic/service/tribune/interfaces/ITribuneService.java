package edu.coursework.philharmonic.service.tribune.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ITribuneService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Tribune;

import java.util.List;

public interface ITribuneService {

    Tribune getById(String id);
    Tribune create(Tribune tribune);
    Tribune update(Tribune tribune);
    Tribune delete(String id);
    List<Tribune> getAll();
}
