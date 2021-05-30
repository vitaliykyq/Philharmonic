package edu.coursework.philharmonic.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    TestingRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.enterprises.model.Testing;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestingRepository extends MongoRepository<Testing, String> {
}
