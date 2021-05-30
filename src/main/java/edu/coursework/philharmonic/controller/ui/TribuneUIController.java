package edu.coursework.philharmonic.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.philharmonic.model.Tribune;
import edu.coursework.philharmonic.service.tribune.impls.TribuneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/tribune")
@Controller
public class TribuneUIController {

    @Autowired
    TribuneServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Tribune> tribuneList = service.getAll();
        model.addAttribute("tribuneList", tribuneList);

        return "tribune/tribuneList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Tribune tribune = service.getById(id);
        model.addAttribute("tribune", tribune);
        return "tribune/updateTribune";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Tribune tribune = new Tribune();
        model.addAttribute("tribune", tribune);
        return "tribune/newTribune";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Tribune tribune) {
        model.addAttribute("tribune", service.create(tribune));
        return "redirect:/ui/tribune/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Tribune tribune) {

        service.update(tribune);
        return "redirect:/ui/tribune/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/tribune/get/all";
    }
}
