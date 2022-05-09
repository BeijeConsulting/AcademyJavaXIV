package it.beije.turing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.turing.example.Contatto;
import it.beije.turing.service.FirstService;


@RestController
public class RestSecondController {

	@Autowired
	private FirstService service;

	@RequestMapping(value = "/elenco_rest", method = RequestMethod.GET)
	public List<Contatto> elencoRest(Model model) {
		System.out.println("GET /elenco_rest " + this.toString());
		
		List<Contatto> rubrica = service.leggiRubrica();
		
		System.out.println(rubrica);
		
		return rubrica;
	}

}
