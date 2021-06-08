package edu.coursework.philharmonic.controller.rest;

/*
    @author:    Julia
    @project:    Philharmonic
    @class:    RoomsRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Rewarding;
import edu.coursework.philharmonic.model.Rooms;
import edu.coursework.philharmonic.service.rewarding.impls.RewardingServiceImpl;
import edu.coursework.philharmonic.service.rooms.impls.RoomsServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/rooms/get/all*/
@Tag(name = "Rooms controller API")
@RestController
@RequestMapping("api/rooms")
public class RoomsRestController {

    @Autowired
    RoomsServiceImpl service;

    @GetMapping("/get/all")
    public List<Rooms> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Rooms getById(@PathVariable("id") String id){
        Rooms byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Rooms deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Rooms create(@RequestBody Rooms rooms){
        return service.create(rooms);
    }

    @PostMapping ("/update/")
    public Rooms update(@RequestBody Rooms rooms){
        return service.update(rooms);
    }

}
