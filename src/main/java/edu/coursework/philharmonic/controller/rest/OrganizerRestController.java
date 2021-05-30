package edu.coursework.philharmonic.controller.rest;

/*
    @author:    Julia
    @project:    Philharmonic
    @class:    OrganizerRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Organizer;
import edu.coursework.philharmonic.service.organizer.impls.OrganizerServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/organizer/get/all*/
@Tag(name = "Organizer controller API")
@RestController
@RequestMapping("api/organizer")
public class OrganizerRestController {

    @Autowired
    OrganizerServiceImpl service;

    @GetMapping("/get/all")
    public List<Organizer> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Organizer getById(@PathVariable("id") String id){
        Organizer byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Organizer deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Organizer create(@RequestBody Organizer organizer){
        return service.create(organizer);
    }

    @PostMapping ("/update/")
    public Organizer update(@RequestBody Organizer organizer){
        return service.update(organizer);
    }

}
