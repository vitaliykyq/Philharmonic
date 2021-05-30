package edu.coursework.philharmonic.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    OrganizerRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.philharmonic.model.Organizer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrganizerRepository extends MongoRepository<Organizer, String> {
}
