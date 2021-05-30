package edu.coursework.philharmonic.controller.rest;

/*
    @author:    Julia
    @project:    Philharmonic
    @class:    ImpresarioRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.philharmonic.model.Impresario;
import edu.coursework.philharmonic.service.impresario.impls.ImpresarioServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/impresario/get/all*/
@Tag(name = "Impresario controller API")
@RestController
@RequestMapping("api/impresario")
public class ImpresarioRestController {

    @Autowired
    ImpresarioServiceImpl service;

    @GetMapping("/get/all")
    public List<Impresario> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Impresario getById(@PathVariable("id") String id){
        Impresario byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Impresario deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Impresario create(@RequestBody Impresario impresario){
        return service.create(impresario);
    }

    @PostMapping ("/update/")
    public Impresario update(@RequestBody Impresario impresario){
        return service.update(impresario);
    }

}
