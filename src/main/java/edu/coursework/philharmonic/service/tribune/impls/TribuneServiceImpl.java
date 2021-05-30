package edu.coursework.philharmonic.service.tribune.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Equipment;
import edu.coursework.enterprises.repository.EquipmentRepository;
import edu.coursework.enterprises.service.equipment.interfaces.IEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TribuneServiceImpl implements IEquipmentService {

    @Autowired
    EquipmentRepository repository;

    @Override
    public Equipment getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Equipment create(Equipment equipment) {
        equipment.setCreated_at(new Date());
        return repository.save(equipment);
    }

    @Override
    public Equipment update(Equipment equipment) {
        equipment.setModified_at(new Date());
        return repository.save(equipment);
    }

    @Override
    public Equipment delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Equipment> getAll() {

        return repository.findAll();
    }
}
