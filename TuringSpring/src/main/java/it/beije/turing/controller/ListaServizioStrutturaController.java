package it.beije.turing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.beije.turing.beans.ListaServizioStruttura;
import it.beije.turing.service.ListaServizioStrutturaService;

@Controller
public class ListaServizioStrutturaController {
	
	@Autowired
	private ListaServizioStrutturaService serviceStr;
	
	@RequestMapping(value ="/mostra_lista_servizio_struttura", method = RequestMethod.GET )
	public String mostraListaServizioStruttura(Model model) {
		System.out.println("LISTA SERVIZIO STRUTTURA");
		List<ListaServizioStruttura> listaServizi = serviceStr.getAllListaServizioStruttura();
		listaServizi.forEach(System.out::println);
		model.addAttribute("listaservizistrutture", listaServizi);
		
		return "mostralistaserviziostruttura";
	}
}
