package edu.coursework.philharmonic.service.rewarding.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    RewardingServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Rewarding;
import edu.coursework.philharmonic.repository.RewardingRepository;
import edu.coursework.philharmonic.service.rewarding.interfaces.IRewardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RewardingServiceImpl implements IRewardingService {

    @Autowired
    RewardingRepository repository;

    @Override
    public Rewarding getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Rewarding create(Rewarding rewarding) {
        rewarding.setCreatedAt(new Date());
        return repository.save(rewarding);
    }

    @Override
    public Rewarding update(Rewarding rewarding) {
        rewarding.setModifiedAt(new Date());
        return repository.save(rewarding);
    }

    @Override
    public Rewarding delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Rewarding> getAll() {

        return repository.findAll();
    }
}
