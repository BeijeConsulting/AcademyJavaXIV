package it.beije.turing.controller;

import it.beije.turing.beans.Struttura;
import it.beije.turing.service.StruttureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StrutturaController {

    @Autowired
    private StruttureService struttureService;

    @RequestMapping(value = "/showAllStrutture", method = RequestMethod.GET)
    public String showAllStrutture(Model model) {
        List<Struttura> strutturas=struttureService.getAllStruttura();
        model.addAttribute("strutture",strutturas);
        return "mostrastrutture";
    }

}
