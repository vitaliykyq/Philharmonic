package edu.coursework.philharmonic.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    RewardingRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.philharmonic.model.Rewarding;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RewardingRepository extends MongoRepository<Rewarding, String> {
}
