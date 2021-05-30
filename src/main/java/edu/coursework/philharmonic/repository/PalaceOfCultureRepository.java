package edu.coursework.philharmonic.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    PalaceOfCultureRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.philharmonic.model.PalaceOfCulture;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PalaceOfCultureRepository extends MongoRepository<PalaceOfCulture, String> {
}
