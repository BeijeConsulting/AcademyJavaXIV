package it.beije.turing.controller;

import it.beije.turing.beans.Indirizzo;
import it.beije.turing.service.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class IndirizzoController {

    @Autowired
    private IndirizzoService indirizzoService;

    @GetMapping(value = "/showAllIndirizzi")
    public List<Indirizzo> showAllIndirizzi() {

        List<Indirizzo> indirizzoList = indirizzoService.getAllIndirizzi();

        return indirizzoList;
    }
}
