package edu.coursework.philharmonic.controller.rest;

/*
    @author:    Julia
    @project:    Philharmonic
    @class:    TheaterRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Theater;
import edu.coursework.philharmonic.service.theater.impls.TheaterServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/theater/get/all*/
@Tag(name = "Theater controller API")
@RestController
@RequestMapping("api/theater")
public class TheaterRestController {

    @Autowired
    TheaterServiceImpl service;

    @GetMapping("/get/all")
    public List<Theater> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Theater getById(@PathVariable("id") String id){
        Theater byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Theater deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Theater create(@RequestBody Theater theater){
        return service.create(theater);
    }

    @PostMapping ("/update/")
    public Theater update(@RequestBody Theater theater){
        return service.update(theater);
    }

}
