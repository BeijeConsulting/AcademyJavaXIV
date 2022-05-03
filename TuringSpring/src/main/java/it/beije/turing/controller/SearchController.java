package it.beije.turing.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.turing.Contatto;
import it.beije.turing.service.JPAcriteriaService;

@Controller
public class SearchController {
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchGet() {
		return "search";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchPost(Model model, @RequestParam String name,  @RequestParam String surname) {
		
		List<Contatto> contatti = JPAcriteriaService.getRubrica();
		List<Contatto> contattiTrovati = new ArrayList<>();
		
		for(Contatto contatto : contatti) {
			if(name.equals(contatto.getNome()) && surname.equals(contatto.getCognome())) {
				contattiTrovati.add(contatto);
			}
		}
		
		model.addAttribute("contattiTrovati", contattiTrovati);
		
		return "searched";
	}
}
