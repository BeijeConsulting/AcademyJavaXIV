package it.beije.turing.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.turing.beans.Annuncio;
import it.beije.turing.beans.ListaServizio;
import it.beije.turing.beans.Servizio;
import it.beije.turing.beans.Struttura;
import it.beije.turing.service.ListaServizioService;
import it.beije.turing.service.ServizioService;
import it.beije.turing.service.StrutturaService;

@RestController
public class ListaServizioController {
	
	@Autowired
	private ListaServizioService serviceListaServizio;
	
	@Autowired
	private ServizioService serviceServizio;
	
	@Autowired
	private StrutturaService str;
	
	@GetMapping(value = "/servicelists")
	public List<ListaServizio> mostraListaServizi() {
		System.out.println("LISTA SERVIZI");
		List<ListaServizio> serviceList = serviceListaServizio.getAllListaServizio();
		System.out.println(serviceList);
		return serviceList;
	}
	
	/***
	 * 
	 * @param model
	 * @param servizioId The object of type "Servizio" stored into the "ListaServizio" that we'll be adding into the database
	 * @param idCollegato The object linked to the "Servizio", a check is occurred to understand if the one passed is one of type "Annuncio" or "Struttura"
	 * @return
	 */
	@PostMapping(value = "/addservicelist")
    public ListaServizio aggiungiListaServizio(@RequestBody ListaServizio serList) {
		serviceListaServizio.addListaServizio(serList);
        return serList;
    }
	
	@DeleteMapping(value = "/deletelistser/{id}")
    public  Map<String, Boolean> eliminaListaServizio(@PathVariable(name = "id") Integer id) {
		Map map = new HashMap<String, Boolean>();
        serviceListaServizio.removeListaServizio(id);
        map.put("esito", Boolean.TRUE);
        return map;
    }
	
	@PutMapping(value = "/updatelistaservizio/{id}")
    public ListaServizio updateListaServizio(@PathVariable(name = "id") Integer id, @RequestBody ListaServizio listSer) {
		serviceListaServizio.updateListaServizio(listSer, id);
        return listSer;
    }
}
