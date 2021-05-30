package edu.coursework.philharmonic.service.organizer.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    IOrganizerService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Organizer;

import java.util.List;

public interface IOrganizerService {

    Organizer getById(String id);
    Organizer create(Organizer organizer);
    Organizer update(Organizer organizer);
    Organizer delete(String id);
    List<Organizer> getAll();
}
