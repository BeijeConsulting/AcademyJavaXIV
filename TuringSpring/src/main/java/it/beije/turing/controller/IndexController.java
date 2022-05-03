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
public class IndexController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model, @RequestParam String order) {
		
		List<Contatto> contatti = new ArrayList<>();
		
		if(order != null && order.equals("nome")) {
			contatti = JPAcriteriaService.getOrderedByNameRubrica();
		} else if(order != null && order.equals("cognome")) {
			contatti = JPAcriteriaService.getOrderedByCognomeRubrica();
		} else {
			contatti = JPAcriteriaService.getRubrica();
		}
		
		model.addAttribute("contatti", contatti);
		
		return "home";
	}
}
