package it.beije.turing.controller;

import it.beije.turing.beans.Immagine;
import it.beije.turing.beans.Struttura;
import it.beije.turing.service.ImmagineService;
import it.beije.turing.service.StruttureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ImmagineController {

    @Autowired
    private ImmagineService immagineService;

    @RequestMapping(value = "/showAllImmage", method = RequestMethod.GET)
    public String showAllStrutture(Model model) {
        List<Immagine> immagines=immagineService.getAllImmagine();
        immagines.forEach(System.out::println);
        model.addAttribute("immagini",immagineService);
        return "mostraimmagini";
    }

}
