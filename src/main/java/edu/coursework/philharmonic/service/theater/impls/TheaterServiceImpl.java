package edu.coursework.philharmonic.service.theater.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    TheaterServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Theater;
import edu.coursework.philharmonic.repository.TheaterRepository;
import edu.coursework.philharmonic.service.theater.interfaces.ITheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TheaterServiceImpl implements ITheaterService {

    @Autowired
    TheaterRepository repository;

    @Override
    public Theater getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Theater create(Theater theater) {
        theater.setCreatedAt(new Date());
        return repository.save(theater);
    }

    @Override
    public Theater update(Theater theater) {
        theater.setModifiedAt(new Date());
        return repository.save(theater);
    }

    @Override
    public Theater delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Theater> getAll() {

        return repository.findAll();
    }
}
