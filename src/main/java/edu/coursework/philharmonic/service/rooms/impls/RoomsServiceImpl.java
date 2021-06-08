package edu.coursework.philharmonic.service.rooms.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    RoomsServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Rewarding;
import edu.coursework.philharmonic.model.Rooms;
import edu.coursework.philharmonic.repository.RewardingRepository;
import edu.coursework.philharmonic.repository.RoomsRepository;
import edu.coursework.philharmonic.service.rooms.interfaces.IRoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoomsServiceImpl implements IRoomsService {

    @Autowired
    RoomsRepository repository;

    @Override
    public Rooms getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Rooms create(Rooms rooms) {
        rooms.setCreatedAt(new Date());
        return repository.save(rooms);
    }

    @Override
    public Rooms update(Rooms rooms) {
        rooms.setModifiedAt(new Date());
        rooms.setCreatedAt(repository.findById(rooms.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(rooms);
        return rooms;
    }

    @Override
    public Rooms delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Rooms> getAll() {

        return repository.findAll();
    }
}
