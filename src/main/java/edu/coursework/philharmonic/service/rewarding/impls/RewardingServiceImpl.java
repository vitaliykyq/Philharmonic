package edu.coursework.philharmonic.service.rewarding.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Military;
import edu.coursework.enterprises.repository.MilitaryRepository;
import edu.coursework.enterprises.service.military.interfaces.IMilitaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RewardingServiceImpl implements IMilitaryService {

    @Autowired
    MilitaryRepository repository;

    @Override
    public Military getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Military create(Military military) {
        military.setCreated_at(new Date());
        return repository.save(military);
    }

    @Override
    public Military update(Military military) {
        military.setModified_at(new Date());
        return repository.save(military);
    }

    @Override
    public Military delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Military> getAll() {

        return repository.findAll();
    }
}
