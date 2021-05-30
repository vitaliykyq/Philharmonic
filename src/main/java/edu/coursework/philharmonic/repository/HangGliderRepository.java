package edu.coursework.philharmonic.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    HangGliderRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.enterprises.model.HangGlider;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HangGliderRepository extends MongoRepository<HangGlider, String> {
}
