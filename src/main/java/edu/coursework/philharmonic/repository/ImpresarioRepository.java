package edu.coursework.philharmonic.repository;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ImpresarioRepository
    @version:    1.0.0 
    @since:    21.05.2021     
*/

import edu.coursework.philharmonic.model.Impresario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImpresarioRepository extends MongoRepository<Impresario, String> {
}
