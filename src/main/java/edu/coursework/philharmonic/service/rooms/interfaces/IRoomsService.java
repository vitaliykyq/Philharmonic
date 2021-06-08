package edu.coursework.philharmonic.service.rooms.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    IRoomsService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Rewarding;
import edu.coursework.philharmonic.model.Rooms;

import java.util.List;

public interface IRoomsService {

    Rooms getById(String id);
    Rooms create(Rooms rooms);
    Rooms update(Rooms rooms);
    Rooms delete(String id);
    List<Rooms> getAll();
}
