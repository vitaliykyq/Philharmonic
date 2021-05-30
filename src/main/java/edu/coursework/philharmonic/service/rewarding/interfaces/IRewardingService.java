package edu.coursework.philharmonic.service.rewarding.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Military;

import java.util.List;

public interface IRewardingService {

    Military getById(String id);
    Military create(Military military);
    Military update(Military military);
    Military delete(String id);
    List<Military> getAll();
}
