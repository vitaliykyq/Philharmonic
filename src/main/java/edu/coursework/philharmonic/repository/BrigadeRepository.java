package edu.coursework.philharmonic.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    BrigadeRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.enterprises.model.Brigade;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BrigadeRepository extends MongoRepository<Brigade, String> {
}
