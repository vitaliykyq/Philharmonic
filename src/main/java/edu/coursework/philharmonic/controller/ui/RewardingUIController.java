package edu.coursework.philharmonic.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.philharmonic.model.Rewarding;
import edu.coursework.philharmonic.service.rewarding.impls.RewardingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/rewarding")
@Controller
public class RewardingUIController {

    @Autowired
    RewardingServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Rewarding> rewardingList = service.getAll();
        model.addAttribute("rewardingList", rewardingList);

        return "rewarding/rewardingList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Military rewarding = service.getById(id);
        model.addAttribute("rewarding", rewarding);
        return "rewarding/updateRewarding";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Rewarding rewarding = new Rewarding();
        model.addAttribute("rewarding", rewarding);
        return "rewarding/newRewarding";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Rewarding rewarding) {
        model.addAttribute("rewarding", service.create(rewarding));
        return "redirect:/ui/rewarding/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Rewarding rewarding) {

        service.update(rewarding);
        return "redirect:/ui/rewarding/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/rewarding/get/all";
    }
}
