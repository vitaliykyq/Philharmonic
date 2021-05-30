package edu.coursework.philharmonic.service.organizer.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Laboratory;

import java.util.List;

public interface IOrganizerService {

    Laboratory getById(String id);
    Laboratory create(Laboratory laboratory);
    Laboratory update(Laboratory laboratory);
    Laboratory delete(String id);
    List<Laboratory> getAll();
}
