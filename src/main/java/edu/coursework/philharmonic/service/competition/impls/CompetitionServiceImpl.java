package edu.coursework.philharmonic.service.competition.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Missile;
import edu.coursework.enterprises.repository.MissileRepository;
import edu.coursework.enterprises.service.missile.interfaces.IMissileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CompetitionServiceImpl implements IMissileService {

    @Autowired
    MissileRepository repository;

    @Override
    public Missile getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Missile create(Missile missile) {
        missile.setCreated_at(new Date());
        return repository.save(missile);
    }

    @Override
    public Missile update(Missile missile) {
        missile.setModified_at(new Date());
        return repository.save(missile);
    }

    @Override
    public Missile delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Missile> getAll() {

        return repository.findAll();
    }
}
