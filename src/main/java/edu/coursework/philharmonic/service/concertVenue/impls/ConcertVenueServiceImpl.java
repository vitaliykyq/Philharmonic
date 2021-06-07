package edu.coursework.philharmonic.service.concertVenue.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Competition;
import edu.coursework.philharmonic.model.ConcertVenue;
import edu.coursework.philharmonic.repository.ConcertVenueRepository;
import edu.coursework.philharmonic.service.concertVenue.interfaces.IConcertVenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ConcertVenueServiceImpl implements IConcertVenueService {

    @Autowired
    ConcertVenueRepository repository;

    @Override
    public ConcertVenue getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public ConcertVenue create(ConcertVenue concertVenue) {
        concertVenue.setCreatedAt(new Date());
        return repository.save(concertVenue);
    }

    @Override
    public ConcertVenue update(ConcertVenue concertVenue) {String id = concertVenue.getId();
        ConcertVenue courtDB = repository.findById(id).orElse(null);
        Date createdAt = courtDB.getCreatedAt();
        concertVenue.setModifiedAt(new Date());
        concertVenue.setCreatedAt(createdAt);
        repository.save(concertVenue);
        return concertVenue;
    }

    @Override
    public ConcertVenue delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<ConcertVenue> getAll() {

        return repository.findAll();
    }
}
