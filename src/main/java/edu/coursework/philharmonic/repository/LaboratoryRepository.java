package edu.coursework.philharmonic.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    LaboratoryRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.enterprises.model.Laboratory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LaboratoryRepository extends MongoRepository<Laboratory, String> {
}
