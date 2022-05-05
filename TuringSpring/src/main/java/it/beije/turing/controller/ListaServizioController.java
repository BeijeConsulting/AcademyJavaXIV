package it.beije.turing.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.turing.beans.ListaServizio;
import it.beije.turing.service.ListaServizioService;

@Controller
public class ListaServizioController {
	
	@Autowired
	private ListaServizioService serviceListaServizio;
	
	@RequestMapping(value = "/mostra_lista_servizio" , method = RequestMethod.GET)
	public String mostraServizi(Model model) {
		System.out.println("LISTA SERVIZIO");
		List<ListaServizio> listaServizi = serviceListaServizio.getAllListaServizio();
		listaServizi.forEach(System.out::println);
		model.addAttribute("listaservizi", listaServizi);
		
		return "mostralistaservizio";
	}
	
}
