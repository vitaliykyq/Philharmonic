package edu.coursework.philharmonic.service.cinema.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.HangGlider;
import edu.coursework.enterprises.repository.HangGliderRepository;
import edu.coursework.enterprises.service.hangGlider.interfaces.IHangGliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CinemaServiceImpl implements IHangGliderService {

    @Autowired
    HangGliderRepository repository;

    @Override
    public HangGlider getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public HangGlider create(HangGlider hangGlider) {
        hangGlider.setCreated_at(new Date());
        return repository.save(hangGlider);
    }

    @Override
    public HangGlider update(HangGlider hangGlider) {
        hangGlider.setModified_at(new Date());
        return repository.save(hangGlider);
    }

    @Override
    public HangGlider delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<HangGlider> getAll() {

        return repository.findAll();
    }
}
