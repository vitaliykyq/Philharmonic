package edu.coursework.philharmonic.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.philharmonic.model.Organizer;
import edu.coursework.philharmonic.service.organizer.impls.OrganizerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/organizer")
@Controller
public class OrganizerUIController {

    @Autowired
    OrganizerServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Organizer> organizerList = service.getAll();
        model.addAttribute("organizerList", organizerList);

        return "organizer/organizerList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Organizer organizer = service.getById(id);
        model.addAttribute("organizer", organizer);
        return "organizer/updateOrganizer";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Organizer organizer = new Organizer();
        model.addAttribute("organizer", organizer);
        return "organizer/newOrganizer";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Organizer organizer) {
        model.addAttribute("organizer", service.create(organizer));
        return "redirect:/ui/organizer/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Organizer organizer) {

        service.update(organizer);
        return "redirect:/ui/organizer/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/organizer/get/all";
    }
}
