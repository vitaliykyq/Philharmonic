package edu.coursework.philharmonic.service.palaceOfCulture.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    IPalaceOfCultureService
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.PalaceOfCulture;

import java.util.List;

public interface IPalaceOfCultureService {

    PalaceOfCulture getById(String id);
    PalaceOfCulture create(PalaceOfCulture palaceOfCulture);
    PalaceOfCulture update(PalaceOfCulture palaceOfCulture);
    PalaceOfCulture delete(String id);
    List<PalaceOfCulture> getAll();
}
