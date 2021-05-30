package edu.coursework.philharmonic.service.organizer.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Laboratory;
import edu.coursework.enterprises.repository.LaboratoryRepository;
import edu.coursework.enterprises.service.laboratory.interfaces.ILaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrganizerServiceImpl implements ILaboratoryService {

    @Autowired
    LaboratoryRepository repository;

    @Override
    public Laboratory getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Laboratory create(Laboratory laboratory) {
        laboratory.setCreated_at(new Date());
        return repository.save(laboratory);
    }

    @Override
    public Laboratory update(Laboratory laboratory) {
        laboratory.setModified_at(new Date());
        return repository.save(laboratory);
    }

    @Override
    public Laboratory delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Laboratory> getAll() {

        return repository.findAll();
    }
}
