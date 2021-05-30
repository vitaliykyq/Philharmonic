package edu.coursework.philharmonic.service.artist.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Brigade;

import java.util.List;

public interface IArtistService {

    Brigade getById(String id);
    Brigade create(Brigade brigade);
    Brigade update(Brigade brigade);
    Brigade delete(String id);
    List<Brigade> getAll();
}
