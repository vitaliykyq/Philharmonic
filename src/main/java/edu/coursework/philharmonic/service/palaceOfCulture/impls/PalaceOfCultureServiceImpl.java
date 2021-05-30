package edu.coursework.philharmonic.service.palaceOfCulture.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Glider;
import edu.coursework.enterprises.repository.GliderRepository;
import edu.coursework.enterprises.service.glider.interfaces.IGliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PalaceOfCultureServiceImpl implements IGliderService {

    @Autowired
    GliderRepository repository;

    @Override
    public Glider getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Glider create(Glider glider) {
        glider.setCreated_at(new Date());
        return repository.save(glider);
    }

    @Override
    public Glider update(Glider glider) {
        glider.setModified_at(new Date());
        return repository.save(glider);
    }

    @Override
    public Glider delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Glider> getAll() {

        return repository.findAll();
    }
}
