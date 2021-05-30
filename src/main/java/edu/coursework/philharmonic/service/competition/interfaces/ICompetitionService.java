package edu.coursework.philharmonic.service.competition.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Missile;

import java.util.List;

public interface ICompetitionService {

    Missile getById(String id);
    Missile create(Missile missile);
    Missile update(Missile missile);
    Missile delete(String id);
    List<Missile> getAll();
}
