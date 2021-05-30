package edu.coursework.philharmonic.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.philharmonic.model.ConcertVenue;
import edu.coursework.philharmonic.service.concertVenue.impls.ConcertVenueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/concertVenue")
@Controller
public class ConcertVenueUIController {

    @Autowired
    ConcertVenueServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<ConcertVenue> concertVenueList = service.getAll();
        model.addAttribute("concertVenueList", concertVenueList);

        return "concertVenue/concertVenueList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        ConcertVenue concertVenue = service.getById(id);
        model.addAttribute("concertVenue", concertVenue);
        return "concertVenue/updateConcertVenue";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        ConcertVenue concertVenue = new ConcertVenue();
        model.addAttribute("concertVenue", concertVenue);
        return "concertVenue/newConcertVenue";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody ConcertVenue concertVenue) {
        model.addAttribute("concertVenue", service.create(concertVenue));
        return "redirect:/ui/concertVenue/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody ConcertVenue concertVenue) {


        service.update(concertVenue);
        return "redirect:/ui/concertVenue/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/civil/get/all";
    }
}
