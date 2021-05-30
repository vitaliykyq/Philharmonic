package edu.coursework.philharmonic.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    HelicopterRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.enterprises.model.Helicopter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HelicopterRepository extends MongoRepository<Helicopter, String> {
}
