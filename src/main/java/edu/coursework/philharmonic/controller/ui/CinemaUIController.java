package edu.coursework.philharmonic.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.philharmonic.model.Cinema;
import edu.coursework.philharmonic.service.cinema.impls.CinemaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/cinema")
@Controller
public class CinemaUIController {

    @Autowired
    CinemaServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Cinema> cinemaList = service.getAll();
        model.addAttribute("cinemaList", cinemaList);

        return "cinema/cinemaList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Cinema cinema = service.getById(id);
        model.addAttribute("cinema",cinema);
        return "cinema/updateCinema";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Cinema cinema = new Cinema();
        model.addAttribute("cinema", cinema);
        return "cinema/newCinema";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Cinema cinema) {
        model.addAttribute("cinema", service.create(cinema));
        return "redirect:/ui/cinema/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Cinema cinema) {

        service.update(cinema);
        return "redirect:/ui/cinema/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/cinema/get/all";
    }
}
