package edu.coursework.philharmonic.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/


import edu.coursework.philharmonic.model.Accounting;
import edu.coursework.philharmonic.service.accounting.impls.AccountingServiceImpl;
import edu.coursework.philharmonic.service.organizer.impls.OrganizerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/accounting")
@Controller
public class AccountingUIController {

    @Autowired
    AccountingServiceImpl accountingService;

    @Autowired
    OrganizerServiceImpl organizerService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Accounting> accountingList = accountingService.getAll();
        model.addAttribute("accountingList", accountingList);

        return "accounting/accountingList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Accounting accounting = accountingService.getById(id);
        model.addAttribute("accounting", accounting);
        return "accounting/updateAccounting";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Accounting accounting = new Accounting();
        model.addAttribute("accounting", accounting);
        return "accounting/newAccounting";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Accounting accounting) {
        accounting.setOrganizer(organizerService.getById(accounting.getOrganizer().getId()));
        model.addAttribute("accounting", accountingService.create(accounting));
        return "redirect:/ui/accounting/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Accounting accounting) {

        accountingService.update(accounting);
        return "redirect:/ui/accounting/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        accountingService.delete(id);
        return "redirect:/ui/accounting/get/all";
    }
}
