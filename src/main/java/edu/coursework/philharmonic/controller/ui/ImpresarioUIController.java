package edu.coursework.philharmonic.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.philharmonic.model.Impresario;
import edu.coursework.philharmonic.service.impresario.impls.ImpresarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/impresario")
@Controller
public class ImpresarioUIController {

    @Autowired
    ImpresarioServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Impresario> impresarioList = service.getAll();
        model.addAttribute("impresarioList", impresarioList);

        return "impresario/impresarioList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Impresario impresario = service.getById(id);
        model.addAttribute("impresario", impresario);
        return "impresario/updateImpresario";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Impresario impresario = new Impresario();
        model.addAttribute("impresario", impresario);
        return "impresario/newImpresario";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Impresario impresario) {
        model.addAttribute("impresario", service.create(impresario));
        return "redirect:/ui/impresario/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Impresario impresario) {

        service.update(impresario);
        return "redirect:/ui/impresario/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/impresario/get/all";
    }
}
