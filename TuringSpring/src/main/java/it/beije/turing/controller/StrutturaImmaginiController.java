package it.beije.turing.controller;

import it.beije.turing.beans.StrutturaImmagini;
import it.beije.turing.service.StrutturaImmaginiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StrutturaImmaginiController {

    @Autowired
    private StrutturaImmaginiService strutturaImmaginiService;

    @RequestMapping(value = "/showAllStruttureImmagini", method = RequestMethod.GET)
    public String showAllStruttureImmagini(Model model) {
        System.out.println("HELLO");
        List<StrutturaImmagini> strutturasImmagini=strutturaImmaginiService.getAllStrutturaImmagini();
        strutturasImmagini.forEach(System.out::println);
        model.addAttribute("strutturaImmagini",strutturasImmagini);
        return "mostrastruttureimmagini";
    }

}
