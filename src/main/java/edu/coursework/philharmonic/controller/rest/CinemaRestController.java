package edu.coursework.philharmonic.controller.rest;

/*
    @author:    Julia
    @project:    Philharmonic
    @class:    CinemaRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Cinema;
import edu.coursework.philharmonic.service.cinema.impls.CinemaServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/cinema/get/all*/
@Tag(name = "Cinema controller API")
@RestController
@RequestMapping("api/cinema")
public class CinemaRestController {

    @Autowired
    CinemaServiceImpl service;

    @GetMapping("/get/all")
    public List<Cinema> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Cinema getById(@PathVariable("id") String id){
        Cinema byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Cinema deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Cinema create(@RequestBody Cinema cinema){
        return service.create(cinema);
    }

    @PostMapping ("/update/")
    public Cinema update(@RequestBody Cinema cinema){
        return service.update(cinema);
    }

}
