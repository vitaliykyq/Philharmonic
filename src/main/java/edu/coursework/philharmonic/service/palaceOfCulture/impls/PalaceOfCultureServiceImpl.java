package edu.coursework.philharmonic.service.palaceOfCulture.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    PalaceOfCultureServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.PalaceOfCulture;
import edu.coursework.philharmonic.repository.PalaceOfCultureRepository;
import edu.coursework.philharmonic.service.palaceOfCulture.interfaces.IPalaceOfCultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PalaceOfCultureServiceImpl implements IPalaceOfCultureService {

    @Autowired
    PalaceOfCultureRepository repository;

    @Override
    public PalaceOfCulture getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public PalaceOfCulture create(PalaceOfCulture palaceOfCulture) {
        palaceOfCulture.setCreatedAt(new Date());
        return repository.save(palaceOfCulture);
    }

    @Override
    public PalaceOfCulture update(PalaceOfCulture palaceOfCulture) {
        palaceOfCulture.setModifiedAt(new Date());
        return repository.save(palaceOfCulture);
    }

    @Override
    public PalaceOfCulture delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<PalaceOfCulture> getAll() {

        return repository.findAll();
    }
}
