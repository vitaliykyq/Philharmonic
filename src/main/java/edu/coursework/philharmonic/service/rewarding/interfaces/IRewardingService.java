package edu.coursework.philharmonic.service.rewarding.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    IRewardingService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Rewarding;

import java.util.List;

public interface IRewardingService {

    Rewarding getById(String id);
    Rewarding create(Rewarding rewarding);
    Rewarding update(Rewarding rewarding);
    Rewarding delete(String id);
    List<Rewarding> getAll();
}
