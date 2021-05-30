package edu.coursework.philharmonic.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    MissileRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.enterprises.model.Missile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MissileRepository extends MongoRepository<Missile, String> {
}
