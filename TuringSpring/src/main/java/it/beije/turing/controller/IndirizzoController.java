package it.beije.turing.controller;

import it.beije.turing.beans.Indirizzo;
import it.beije.turing.service.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.util.List;


@Controller
public class IndirizzoController {

    @Autowired
    private IndirizzoService indirizzoService;

    @RequestMapping(value = "/showAllIndirizzi", method = RequestMethod.GET)
    public String showAllIndirizzi(Model model) {
        List<Indirizzo> indirizzoList = indirizzoService.getAllIndirizzi();

        model.addAttribute("indirizzi", indirizzoList);
        return "mostraindirizzo";
    }
}
