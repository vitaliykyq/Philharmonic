package edu.coursework.philharmonic.service.competition.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CompetitionServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Competition;
import edu.coursework.philharmonic.repository.CompetitionRepository;
import edu.coursework.philharmonic.service.competition.interfaces.ICompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CompetitionServiceImpl implements ICompetitionService {

    @Autowired
    CompetitionRepository repository;

    @Override
    public Competition getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Competition create(Competition competition) {
        competition.setCreatedAt(new Date());
        return repository.save(competition);
    }

    @Override
    public Competition update(Competition competition) {
        competition.setModifiedAt(new Date());
        return repository.save(competition);
    }

    @Override
    public Competition delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Competition> getAll() {

        return repository.findAll();
    }
}
