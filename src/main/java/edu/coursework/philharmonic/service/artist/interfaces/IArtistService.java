package edu.coursework.philharmonic.service.artist.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    IArtistService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Artist;

import java.util.List;

public interface IArtistService {

    Artist getById(String id);
    Artist create(Artist artist);
    Artist update(Artist artist);
    Artist delete(String id);
    List<Artist> getAll();
}
