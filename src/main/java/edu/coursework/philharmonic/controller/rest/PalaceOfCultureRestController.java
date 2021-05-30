package edu.coursework.philharmonic.controller.rest;

/*
    @author:    Julia
    @project:    Philharmonic
    @class:    PalaceOfCultureRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.PalaceOfCulture;
import edu.coursework.philharmonic.service.palaceOfCulture.impls.PalaceOfCultureServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/palaceOfCulture/get/all*/
@Tag(name = "PalaceOfCulture controller API")
@RestController
@RequestMapping("api/palaceOfCulture")
public class PalaceOfCultureRestController {

    @Autowired
    PalaceOfCultureServiceImpl service;

    @GetMapping("/get/all")
    public List<PalaceOfCulture> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public PalaceOfCulture getById(@PathVariable("id") String id){
        PalaceOfCulture byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public PalaceOfCulture deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public PalaceOfCulture create(@RequestBody PalaceOfCulture palaceOfCulture){
        return service.create(palaceOfCulture);
    }

    @PostMapping ("/update/")
    public PalaceOfCulture update(@RequestBody PalaceOfCulture palaceOfCulture){
        return service.update(palaceOfCulture);
    }

}
