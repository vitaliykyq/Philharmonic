package edu.coursework.philharmonic.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ProduceRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.enterprises.model.Produce;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProduceRepository extends MongoRepository<Produce, String> {
}
