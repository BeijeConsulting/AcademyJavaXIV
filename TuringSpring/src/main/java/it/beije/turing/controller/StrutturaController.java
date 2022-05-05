package it.beije.turing.controller;

import it.beije.turing.beans.Struttura;
import it.beije.turing.service.ServiceStrutture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StrutturaController {

    @Autowired
    private ServiceStrutture serviceStrutture;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String loginGet() {
        System.out.println("HELLO");
        serviceStrutture.getAll().forEach(System.out::println);

        return "index";
    }

}
