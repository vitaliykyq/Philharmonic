package edu.coursework.philharmonic.service.cinema.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CinemaServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Cinema;
import edu.coursework.philharmonic.repository.CinemaRepository;
import edu.coursework.philharmonic.service.cinema.interfaces.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CinemaServiceImpl implements ICinemaService {

    @Autowired
    CinemaRepository repository;

    @Override
    public Cinema getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Cinema create(Cinema cinema) {
        cinema.setCreatedAt(new Date());
        return repository.save(cinema);
    }

    @Override
    public Cinema update(Cinema cinema) {
        cinema.setModifiedAt(new Date());
        return repository.save(cinema);
    }

    @Override
    public Cinema delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Cinema> getAll() {

        return repository.findAll();
    }
}
