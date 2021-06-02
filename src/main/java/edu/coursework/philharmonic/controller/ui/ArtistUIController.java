package edu.coursework.philharmonic.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.philharmonic.model.Artist;
import edu.coursework.philharmonic.model.Impresario;
import edu.coursework.philharmonic.service.artist.impls.ArtistServiceImpl;
import edu.coursework.philharmonic.service.impresario.impls.ImpresarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/artist")
@Controller
public class ArtistUIController {

    @Autowired
    ArtistServiceImpl service;

    @Autowired
    ImpresarioServiceImpl impresarioService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Artist> artistList = service.getAll();
        model.addAttribute("artistList", artistList);

        return "artist/artistList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Artist artist = service.getById(id);
        model.addAttribute("artist",artist);

        List<Impresario> impresarioIdList = impresarioService.getAll();
        model.addAttribute("impresarioIdList", impresarioIdList);
        return "artist/updateArtist";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Artist artist = new Artist();
        model.addAttribute("artist", artist);

        List<Impresario> impresarioIdList = impresarioService.getAll();
        model.addAttribute("impresarioIdList", impresarioIdList);
        return "artist/newArtist";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Artist artist) {
        /*artist.setImpresarioList(impresarioService.getById(artist.getImpresarioList().getId()));*/
        model.addAttribute("artist", service.create(artist));
        return "redirect:/ui/artist/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Artist artist) {

        service.update(artist);
        return "redirect:/ui/artist/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/artist/get/all";
    }
}
