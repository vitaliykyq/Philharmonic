package edu.coursework.philharmonic.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    AccountingRepository 
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.enterprises.model.Accounting;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountingRepository extends MongoRepository<Accounting, String> {
}
