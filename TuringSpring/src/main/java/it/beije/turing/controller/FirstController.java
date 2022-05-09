package it.beije.turing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.turing.beans.Annuncio;
import it.beije.turing.service.FirstService;
import it.beije.turing.service.ServiceAnnuncio;


@Controller
public class FirstController
{
	
	@Autowired
	private ServiceAnnuncio serviceAnnuncio;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {

		List<Annuncio> annunci = serviceAnnuncio.getAnnuncio();
		
		for(Annuncio a : annunci)
		{
			System.out.println(a.toString());
		}
		
		return "index";
	}
}