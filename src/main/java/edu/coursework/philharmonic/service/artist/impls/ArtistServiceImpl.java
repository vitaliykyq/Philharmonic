package edu.coursework.philharmonic.service.artist.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Artist;
import edu.coursework.philharmonic.repository.ArtistRepository;
import edu.coursework.philharmonic.service.artist.interfaces.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArtistServiceImpl implements IArtistService {

    @Autowired
    ArtistRepository repository;

    @Override
    public Artist getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Artist create(Artist artist) {
        artist.setCreatedAt(new Date());
        return repository.save(artist);
    }

    @Override
    public Artist update(Artist artist) {
        artist.setModifiedAt(new Date());
        return repository.save(artist);
    }

    @Override
    public Artist delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Artist> getAll() {

        return repository.findAll();
    }
}
