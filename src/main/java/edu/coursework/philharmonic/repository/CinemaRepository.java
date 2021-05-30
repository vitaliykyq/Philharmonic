package edu.coursework.philharmonic.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CinemaRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.philharmonic.model.Cinema;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CinemaRepository extends MongoRepository<Cinema, String> {
}
