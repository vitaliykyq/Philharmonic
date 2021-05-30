package edu.coursework.philharmonic.service.competition.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICompetitionService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Competition;

import java.util.List;

public interface ICompetitionService {

    Competition getById(String id);
    Competition create(Competition competition);
    Competition update(Competition competition);
    Competition delete(String id);
    List<Competition> getAll();
}
