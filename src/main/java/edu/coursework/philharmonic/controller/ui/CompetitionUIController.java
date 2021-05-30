package edu.coursework.philharmonic.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.philharmonic.model.Competition;
import edu.coursework.philharmonic.service.artist.impls.ArtistServiceImpl;
import edu.coursework.philharmonic.service.competition.impls.CompetitionServiceImpl;
import edu.coursework.philharmonic.service.organizer.impls.OrganizerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/competition")
@Controller
public class CompetitionUIController {

    @Autowired
    CompetitionServiceImpl competitionService;

    @Autowired
    ArtistServiceImpl artistService;

    @Autowired
    OrganizerServiceImpl organizerService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Competition> competitionList = competitionService.getAll();
        model.addAttribute("competitionList", competitionList);

        return "competition/competitionList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Competition competition = competitionService.getById(id);
        model.addAttribute("competition", competition);
        return "competition/updateCompetition";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Competition competition = new Competition();
        model.addAttribute("competition", competition);
        return "competition/newCompetition";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Competition competition) {
        competition.setLaureate(artistService.getById(competition.getLaureate().getId()));
        competition.setOrganizer(organizerService.getById(competition.getOrganizer().getId()));
        model.addAttribute("competition", competitionService.create(competition));
        return "redirect:/ui/competition/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Competition competition) {
        competitionService.update(competition);
        return "redirect:/ui/competition/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        competitionService.delete(id);
        return "redirect:/ui/competition/get/all";
    }
}
