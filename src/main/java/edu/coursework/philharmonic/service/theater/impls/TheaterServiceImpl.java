package edu.coursework.philharmonic.service.theater.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Civil;
import edu.coursework.enterprises.repository.CivilRepository;
import edu.coursework.enterprises.service.civil.interfaces.ICivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TheaterServiceImpl implements ICivilService {

    @Autowired
    CivilRepository repository;

    @Override
    public Civil getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Civil create(Civil civil) {
        civil.setCreatedAt(new Date());
        return repository.save(civil);
    }

    @Override
    public Civil update(Civil civil) {
        civil.setModifiedAt(new Date());
        return repository.save(civil);
    }

    @Override
    public Civil delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Civil> getAll() {

        return repository.findAll();
    }
}
