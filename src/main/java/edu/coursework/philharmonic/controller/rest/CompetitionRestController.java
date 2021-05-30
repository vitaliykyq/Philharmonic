package edu.coursework.philharmonic.controller.rest;

/*
    @author:    Julia
    @project:    Philharmonic
    @class:    CompetitionRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Competition;
import edu.coursework.philharmonic.service.competition.impls.CompetitionServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/competition/get/all*/
@Tag(name = "Competition controller API")
@RestController
@RequestMapping("api/competition")
public class CompetitionRestController {

    @Autowired
    CompetitionServiceImpl service;

    @GetMapping("/get/all")
    public List<Competition> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Competition getById(@PathVariable("id") String id){
        Competition byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Competition deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Competition create(@RequestBody Competition competition){
        return service.create(competition);
    }

    @PostMapping ("/update/")
    public Competition update(@RequestBody Competition competition){
        return service.update(competition);
    }

}
