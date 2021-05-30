package edu.coursework.philharmonic.controller.rest;

/*
    @author:    Julia
    @project:    Philharmonic
    @class:    RewardingRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Rewarding;
import edu.coursework.philharmonic.service.rewarding.impls.RewardingServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/rewarding/get/all*/
@Tag(name = "Rewarding controller API")
@RestController
@RequestMapping("api/rewarding")
public class RewardingRestController {

    @Autowired
    RewardingServiceImpl service;

    @GetMapping("/get/all")
    public List<Rewarding> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Rewarding getById(@PathVariable("id") String id){
        Rewarding byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Rewarding deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Rewarding create(@RequestBody Rewarding rewarding){
        return service.create(rewarding);
    }

    @PostMapping ("/update/")
    public Rewarding update(@RequestBody Rewarding rewarding){
        return service.update(rewarding);
    }

}
