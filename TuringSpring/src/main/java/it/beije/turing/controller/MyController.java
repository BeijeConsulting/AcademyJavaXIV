package it.beije.turing.controller;

import it.beije.turing.Contatto;
import it.beije.turing.service.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private MyUtils utils;

    @RequestMapping(value = "/saluta", method = RequestMethod.GET)
    public String helloWord(@RequestParam(name = "nome",required = false) String name, Model model){
        if(name!=null){
            System.out.println("Ciao: "+name);
            model.addAttribute("Saluta", "Ciao "+name);
        }else {
            System.out.println("Ciao a tutti");
            model.addAttribute("Saluta","Ciao a tutti");
        }

        return "saluta";
    }
    @RequestMapping(value = "/gen",method = RequestMethod.GET)
    public String listaRandom(@RequestParam(name = "num", required = false) int numero,Model model){

            List<Contatto> list= new ArrayList<>();
            for (int i = 0; i < numero; i++) {
                Contatto contatto= new Contatto();
                contatto.setId(i);
                contatto.setNome(utils.genName());
                contatto.setCognome(utils.getSuranme());
                contatto.setEmail(utils.genEmail());
                contatto.setNote(utils.genNote());
                contatto.setTelefono(utils.getTel());
                list.add(contatto);
                System.out.println(contatto);
            }

            model.addAttribute("list",list);

            return "lista";
    }
}
