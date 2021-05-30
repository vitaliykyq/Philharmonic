package edu.coursework.philharmonic.service.concertVenue.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    IConcertVenueService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.ConcertVenue;

import java.util.List;

public interface IConcertVenueService {

    ConcertVenue getById(String id);
    ConcertVenue create(ConcertVenue concertVenue);
    ConcertVenue update(ConcertVenue concertVenue);
    ConcertVenue delete(String id);
    List<ConcertVenue> getAll();
}
