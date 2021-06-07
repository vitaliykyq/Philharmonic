package edu.coursework.philharmonic.service.organizer.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    OrganizerServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Organizer;
import edu.coursework.philharmonic.repository.OrganizerRepository;
import edu.coursework.philharmonic.service.organizer.interfaces.IOrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrganizerServiceImpl implements IOrganizerService {

    @Autowired
    OrganizerRepository repository;

    @Override
    public Organizer getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Organizer create(Organizer organizer) {
        organizer.setCreatedAt(new Date());
        return repository.save(organizer);
    }

    @Override
    public Organizer update(Organizer organizer) {
        organizer.setModifiedAt(new Date());
        organizer.setCreatedAt(repository.findById(organizer.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(organizer);
        return organizer;
    }

    @Override
    public Organizer delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Organizer> getAll() {

        return repository.findAll();
    }
}
