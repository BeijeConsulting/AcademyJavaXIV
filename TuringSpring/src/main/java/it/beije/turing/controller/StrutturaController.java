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
        System.out.println("HELLO");
        List<Struttura> strutturas=struttureService.getAll();
        strutturas.forEach(System.out::println);
        model.addAttribute("strutture",strutturas);
        return "mostrastrutture";
    }

}
