package it.beije.turing.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.turing.beans.Annuncio;
import it.beije.turing.beans.ListaServizio;
import it.beije.turing.beans.Servizio;
import it.beije.turing.beans.Struttura;
import it.beije.turing.service.ListaServizioService;
import it.beije.turing.service.ServizioService;
import it.beije.turing.service.StrutturaService;

@Controller
public class ListaServizioController {
	
	@Autowired
	private ListaServizioService serviceListaServizio;
	
	@Autowired
	private ServizioService serviceServizio;
	
	@Autowired
	private StrutturaService str;
	
	@RequestMapping(value = "/mostra_lista_servizio" , method = RequestMethod.GET)
	public String mostraListaServizi(Model model) {
		System.out.println("LISTA SERVIZIO");
		List<ListaServizio> listaServizi = serviceListaServizio.getAllListaServizio();
		listaServizi.forEach(System.out::println);
		model.addAttribute("listaservizi", listaServizi);
		
		return "mostralistaservizio";
	}
	
	/***
	 * 
	 * @param model
	 * @param servizioId The object of type "Servizio" stored into the "ListaServizio" that we'll be adding into the database
	 * @param idCollegato The object linked to the "Servizio", a check is occurred to understand if the one passed is one of type "Annuncio" or "Struttura"
	 * @return
	 */
	@RequestMapping(value = "/aggiungilistaservizio", method = RequestMethod.GET)
    public String aggiungiListaServizio(Model model, @RequestParam(name = "servizioId") Integer servizioId , @RequestParam(name = "idCollegato") Object idCollegato) {
		ListaServizio listSer = new ListaServizio();
		listSer.setServizioId(serviceServizio.getById(servizioId));
		Annuncio annuncio = null;
		Struttura struttura = null;
		
		if(idCollegato instanceof Annuncio) {
			annuncio = (Annuncio)idCollegato;
			listSer.setAnnuncioId(annuncio);
		}
			
		if(idCollegato instanceof Struttura) {
			struttura = (Struttura)idCollegato;
			listSer.setStrutturaId(struttura);
		}
		serviceListaServizio.addListaServizio(listSer);
        return "mostralistaservizio";
    }
	
	@RequestMapping(value = "/eliminalistaservizio", method = RequestMethod.GET)
    public String eliminaListaServizio(Model model, @RequestParam(name = "id") Integer servizioId) {
        serviceServizio.removeServizio(servizioId);
        return "eliminaservizio";
    }
	
	@RequestMapping(value = "/updatelistaservizio", method = RequestMethod.GET)
    public String updateListaServizio(Model model, @RequestParam(name = "id") Integer listSerId, 
    		@RequestParam(name = "idCollegato" ) Object idCollegato) {
		ListaServizio listSer = new ListaServizio();
		Annuncio annuncio = null;
		Struttura struttura = null;
		
		if(idCollegato instanceof Annuncio) {
			annuncio = (Annuncio)idCollegato;
			listSer.setAnnuncioId(annuncio);
		}
			
		if(idCollegato instanceof Struttura) {
			struttura = (Struttura)idCollegato;
			listSer.setStrutturaId(struttura);
		}
		serviceListaServizio.updateListaServizio(listSer, listSerId);
		
        return "updatelistaservizio";
    }
	
	
	
	@RequestMapping(value ="/test", method = RequestMethod.GET)
	public String testing() {
		this.stampa();
		System.out.println("LISTA SERVIZIO");
		
        ListaServizio listSer = new ListaServizio();
        Struttura struttura = str.findStrutturaById(1);
        listSer.setServizioId(serviceServizio.getById(1));
        listSer.setStrutturaId(struttura);
        
        System.out.println("AGGIUNGI");
        serviceListaServizio.addListaServizio(listSer);
        stampa();
        
        System.out.println("MODIFICA");
        listSer.setStrutturaId(str.findStrutturaById(2));
        serviceListaServizio.updateListaServizio(listSer, listSer.getId());
        this.stampa();
        
        System.out.println("DELETE");
        serviceListaServizio.removeListaServizio(listSer.getId());
        this.stampa();
		return "index";
	}
	
	public void stampa() {
		List<ListaServizio> lista = serviceListaServizio.getAllListaServizio();
		for(ListaServizio s : lista)
			System.out.println(s);
	}
	
	
}
