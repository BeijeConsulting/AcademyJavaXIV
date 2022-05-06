package it.beije.turing.controller;

import it.beije.turing.service.ImmagineService;
import it.beije.turing.service.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/indirizzo")
@Controller
public class IndirizzoController {

    @Autowired
    private IndirizzoService indirizzoService;
}
