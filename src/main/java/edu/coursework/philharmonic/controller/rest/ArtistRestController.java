package edu.coursework.philharmonic.controller.rest;

/*
    @author:    Julia
    @project:    Philharmonic
    @class:    ArtistRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Artist;
import edu.coursework.philharmonic.service.artist.impls.ArtistServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/artist/get/all*/
@Tag(name = "Artist controller API")
@RestController
@RequestMapping("api/artist")
public class ArtistRestController {

    @Autowired
    ArtistServiceImpl service;

    @GetMapping("/get/all")
    public List<Artist> getCivil(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Artist getById(@PathVariable("id") String id){
        Artist byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Artist deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Artist create(@RequestBody Artist artist){
        return service.create(artist);
    }

    @PostMapping ("/update/")
    public Artist update(@RequestBody Artist artist){
        return service.update(artist);
    }

}
