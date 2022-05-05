package it.beije.turing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.turing.beans.Annuncio;
import it.beije.turing.service.FirstService;


@Controller
public class FirstController
{
	
	@Autowired
	private FirstService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {

		List<Annuncio> annunci = service.getAnnuncio();
		
		for(Annuncio a : annunci)
		{
			System.out.println(a.toString());
		}
		
		return "index";
	}
}