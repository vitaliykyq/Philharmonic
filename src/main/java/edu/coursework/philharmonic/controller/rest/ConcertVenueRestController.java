package edu.coursework.philharmonic.controller.rest;

/*
    @author:    Julia
    @project:    Philharmonic
    @class:    ConcertVenueRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.ConcertVenue;
import edu.coursework.philharmonic.service.concertVenue.impls.ConcertVenueServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/concertVenue/get/all*/
@Tag(name = "ConcertVenue controller API")
@RestController
@RequestMapping("api/concertVenue")
public class ConcertVenueRestController {

    @Autowired
    ConcertVenueServiceImpl service;

    @GetMapping("/get/all")
    public List<ConcertVenue> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public ConcertVenue getById(@PathVariable("id") String id){
        ConcertVenue byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public ConcertVenue deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public ConcertVenue create(@RequestBody ConcertVenue concertVenue){
        return service.create(concertVenue);
    }

    @PostMapping ("/update/")
    public ConcertVenue update(@RequestBody ConcertVenue concertVenue){
        return service.update(concertVenue);
    }

}
