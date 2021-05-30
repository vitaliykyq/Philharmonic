package edu.coursework.philharmonic.controller.rest;

/*
    @author:    Julia
    @project:    Philharmonic
    @class:    TribuneRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Tribune;
import edu.coursework.philharmonic.service.tribune.impls.TribuneServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/tribune/get/all*/
@Tag(name = "Tribune controller API")
@RestController
@RequestMapping("api/tribune")
public class TribuneRestController {

    @Autowired
    TribuneServiceImpl service;

    @GetMapping("/get/all")
    public List<Tribune> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Tribune getById(@PathVariable("id") String id){
        Tribune byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Tribune deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Tribune create(@RequestBody Tribune tribune){
        return service.create(tribune);
    }

    @PostMapping ("/update/")
    public Tribune update(@RequestBody Tribune tribune){
        return service.update(tribune);
    }

}
