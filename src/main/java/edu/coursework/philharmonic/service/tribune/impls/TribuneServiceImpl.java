package edu.coursework.philharmonic.service.tribune.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    TribuneServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Tribune;
import edu.coursework.philharmonic.repository.TribuneRepository;
import edu.coursework.philharmonic.service.tribune.interfaces.ITribuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TribuneServiceImpl implements ITribuneService {

    @Autowired
    TribuneRepository repository;

    @Override
    public Tribune getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Tribune create(Tribune tribune) {
        tribune.setCreatedAt(new Date());
        return repository.save(tribune);
    }

    @Override
    public Tribune update(Tribune tribune) {
        tribune.setModifiedAt(new Date());
        tribune.setCreatedAt(repository.findById(tribune.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(tribune);
        return tribune;
    }

    @Override
    public Tribune delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Tribune> getAll() {

        return repository.findAll();
    }
}
