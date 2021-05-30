package edu.coursework.philharmonic.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.philharmonic.model.PalaceOfCulture;
import edu.coursework.philharmonic.service.palaceOfCulture.impls.PalaceOfCultureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/palaceOfCulture")
@Controller
public class PalaceOfCultureUIController {

    @Autowired
    PalaceOfCultureServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<PalaceOfCulture> palaceOfCultureList = service.getAll();
        model.addAttribute("palaceOfCultureList", palaceOfCultureList);

        return "palaceOfCulture/palaceOfCultureList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        PalaceOfCulture palaceOfCulture = service.getById(id);
        model.addAttribute("palaceOfCulture", palaceOfCulture);
        return "palaceOfCulture/updateEquipment";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        PalaceOfCulture palaceOfCulture = new PalaceOfCulture();
        model.addAttribute("palaceOfCulture", palaceOfCulture);
        return "palaceOfCulture/newEquipment";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody PalaceOfCulture palaceOfCulture) {
        model.addAttribute("palaceOfCulture", service.create(palaceOfCulture));
        return "redirect:/ui/palaceOfCulture/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody PalaceOfCulture palaceOfCulture) {

        service.update(palaceOfCulture);
        return "redirect:/ui/palaceOfCulture/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/palaceOfCulture/get/all";
    }
}
