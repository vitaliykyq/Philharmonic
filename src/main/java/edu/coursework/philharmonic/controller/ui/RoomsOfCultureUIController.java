package edu.coursework.philharmonic.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    RoomsOfCultureUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.philharmonic.model.*;
import edu.coursework.philharmonic.service.cinema.impls.CinemaServiceImpl;
import edu.coursework.philharmonic.service.concertVenue.impls.ConcertVenueServiceImpl;
import edu.coursework.philharmonic.service.palaceOfCulture.impls.PalaceOfCultureServiceImpl;
import edu.coursework.philharmonic.service.rooms.impls.RoomsServiceImpl;
import edu.coursework.philharmonic.service.theater.impls.TheaterServiceImpl;
import edu.coursework.philharmonic.service.tribune.impls.TribuneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/rooms")
@Controller
public class RoomsOfCultureUIController {

    @Autowired
    RoomsServiceImpl roomsService;

    @Autowired
    PalaceOfCultureServiceImpl palaceOfCultureService;

    @Autowired
    ConcertVenueServiceImpl concertVenueService;

    @Autowired
    TheaterServiceImpl theaterService;

    @Autowired
    CinemaServiceImpl cinemaService;

    @Autowired
    TribuneServiceImpl tribuneService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Rooms> roomsList = roomsService.getAll();
        model.addAttribute("roomsList", roomsList);

        return "rooms/roomsList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Rooms rooms = roomsService.getById(id);
        model.addAttribute("rooms", rooms);

        List<PalaceOfCulture> palaceOfCultureListId = palaceOfCultureService.getAll();
        model.addAttribute("palaceOfCultureListId", palaceOfCultureListId);

        List<ConcertVenue> concertVenueListId = concertVenueService.getAll();
        model.addAttribute("concertVenueListId", concertVenueListId);

        List<Theater> theaterListId = theaterService.getAll();
        model.addAttribute("theaterListId", theaterListId);

        List<Cinema> cinemaListId = cinemaService.getAll();
        model.addAttribute("cinemaListId", cinemaListId);

        List<Tribune> tribuneListId = tribuneService.getAll();
        model.addAttribute("tribuneListId", tribuneListId);
        return "rooms/updateRooms";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Rooms rooms = new Rooms();
        model.addAttribute("rooms", rooms);

        List<PalaceOfCulture> palaceOfCultureListId = palaceOfCultureService.getAll();
        model.addAttribute("palaceOfCultureListId", palaceOfCultureListId);

        List<ConcertVenue> concertVenueListId = concertVenueService.getAll();
        model.addAttribute("concertVenueListId", concertVenueListId);

        List<Theater> theaterListId = theaterService.getAll();
        model.addAttribute("theaterListId", theaterListId);

        List<Cinema> cinemaListId = cinemaService.getAll();
        model.addAttribute("cinemaListId", cinemaListId);

        List<Tribune> tribuneListId = tribuneService.getAll();
        model.addAttribute("tribuneListId", tribuneListId);
        return "rooms/newRooms";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("rooms") @RequestBody Rooms rooms) {
        model.addAttribute("rooms", roomsService.create(rooms));
        return "redirect:/ui/rooms/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("rooms") @RequestBody Rooms rooms) {

        roomsService.update(rooms);
        return "redirect:/ui/rooms/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        roomsService.delete(id);
        return "redirect:/ui/rooms/get/all";
    }
}
