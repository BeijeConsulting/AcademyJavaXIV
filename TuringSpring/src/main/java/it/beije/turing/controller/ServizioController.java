package it.beije.turing.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.turing.beans.Servizio;
import it.beije.turing.service.ServizioService;

@Controller
public class ServizioController {
	
	@Autowired
	private ServizioService serviceServizio;
	
	@RequestMapping(value = "/mostraservizio" , method = RequestMethod.GET)
	public String mostraServizi(Model model) {
		System.out.println("SERVIZIO");
		List<Servizio> servizi = serviceServizio.getAllServizio();
		servizi.forEach(System.out::println);
		model.addAttribute("servizi", servizi);
		return "mostraservizio";
	}
	
}
