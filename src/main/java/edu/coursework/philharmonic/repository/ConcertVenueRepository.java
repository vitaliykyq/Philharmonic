package edu.coursework.philharmonic.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ConcertVenueRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.philharmonic.model.ConcertVenue;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConcertVenueRepository extends MongoRepository<ConcertVenue, String> {
}
