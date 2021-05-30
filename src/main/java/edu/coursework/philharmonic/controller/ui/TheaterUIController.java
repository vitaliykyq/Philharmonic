package edu.coursework.philharmonic.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.philharmonic.model.Theater;
import edu.coursework.philharmonic.service.theater.impls.TheaterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/theater")
@Controller
public class TheaterUIController {

    @Autowired
    TheaterServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Theater> theaterList = service.getAll();
        model.addAttribute("theaterList", theaterList);

        return "theater/theaterList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Theater theater = service.getById(id);
        model.addAttribute("theater", theater);
        return "theater/updateTheater";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Theater theater = new Theater();
        model.addAttribute("theater", theater);
        return "theater/newTheater";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Theater theater) {
        model.addAttribute("theater", service.create(theater));
        return "redirect:/ui/theater/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Theater theater) {

        service.update(theater);
        return "redirect:/ui/theater/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/theater/get/all";
    }
}
