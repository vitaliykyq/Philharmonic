package edu.coursework.philharmonic.service.impresario.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ImpresarioServiceImpl
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Impresario;
import edu.coursework.philharmonic.repository.ImpresarioRepository;
import edu.coursework.philharmonic.service.impresario.interfaces.IImpresarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ImpresarioServiceImpl implements IImpresarioService {

    @Autowired
    ImpresarioRepository repository;

    @Override
    public Impresario getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Impresario create(Impresario impresario) {
        impresario.setCreatedAt(new Date());
        return repository.save(impresario);
    }

    @Override
    public Impresario update(Impresario impresario) {
        impresario.setModifiedAt(new Date());
        impresario.setCreatedAt(repository.findById(impresario.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(impresario);
        return impresario;
    }

    @Override
    public Impresario delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Impresario> getAll() {

        return repository.findAll();
    }
}
