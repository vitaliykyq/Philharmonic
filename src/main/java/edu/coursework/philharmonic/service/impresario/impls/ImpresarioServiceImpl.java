package edu.coursework.philharmonic.service.impresario.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Helicopter;
import edu.coursework.enterprises.repository.HelicopterRepository;
import edu.coursework.enterprises.service.helicopter.interfaces.IHelicopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ImpresarioServiceImpl implements IHelicopterService {

    @Autowired
    HelicopterRepository repository;

    @Override
    public Helicopter getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Helicopter create(Helicopter helicopter) {
        helicopter.setCreated_at(new Date());
        return repository.save(helicopter);
    }

    @Override
    public Helicopter update(Helicopter helicopter) {
        helicopter.setModified_at(new Date());
        return repository.save(helicopter);
    }

    @Override
    public Helicopter delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Helicopter> getAll() {

        return repository.findAll();
    }
}
