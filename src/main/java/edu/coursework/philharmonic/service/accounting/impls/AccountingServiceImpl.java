package edu.coursework.philharmonic.service.accounting.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Accounting;
import edu.coursework.philharmonic.model.Cinema;
import edu.coursework.philharmonic.repository.AccountingRepository;
import edu.coursework.philharmonic.service.accounting.interfaces.IAccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountingServiceImpl implements IAccountingService {

    @Autowired
    AccountingRepository repository;

    @Override
    public Accounting getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Accounting create(Accounting accounting) {
        accounting.setCreatedAt(new Date());
        return repository.save(accounting);
    }

    @Override
    public Accounting update(Accounting accounting) {String id = accounting.getId();
        Accounting courtDB = repository.findById(id).orElse(null);
        Date createdAt = courtDB.getCreatedAt();
        accounting.setModifiedAt(new Date());
        accounting.setCreatedAt(createdAt);
        repository.save(accounting);
        return accounting;
    }

    @Override
    public Accounting delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Accounting> getAll() {

        return repository.findAll();
    }
}
