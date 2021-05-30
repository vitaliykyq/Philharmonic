package edu.coursework.philharmonic.service.concertVenue.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Engineer;

import java.util.List;

public interface IConcertVenueService {

    Engineer getById(String id);
    Engineer create(Engineer engineer);
    Engineer update(Engineer engineer);
    Engineer delete(String id);
    List<Engineer> getAll();
}
