package edu.coursework.philharmonic.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    PlotRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.enterprises.model.Plot;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlotRepository extends MongoRepository<Plot, String> {
}
