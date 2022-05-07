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

@Controller
public class ListaServizioController {
	
	@Autowired
	private ListaServizioService serviceListaServizio;
	
	@Autowired
	private ServizioService serviceServizio;
	
	@RequestMapping(value = "/mostra_lista_servizio" , method = RequestMethod.GET)
	public String mostraListaServizi(Model model) {
		System.out.println("LISTA SERVIZIO");
		List<ListaServizio> listaServizi = serviceListaServizio.getAllListaServizio();
		listaServizi.forEach(System.out::println);
		model.addAttribute("listaservizi", listaServizi);
		
		return "mostralistaservizio";
	}
	
	@RequestMapping(value = "/aggiungilistaservizio", method = RequestMethod.GET)
    public String aggiungiListaServizio(Model model) {
//		ListaServizio listSer = new ListaServizio();
//		listSer.setServizioId(serviceServizio.getById(servizioId));
//		Annuncio annuncio = null;
//		Struttura struttura = null;
//		
//		if(o instanceof Annuncio) {
//			annuncio = (Annuncio)o;
//			listSer.setAnnuncioId(annuncio);
//		}
//			
//		if(o instanceof Struttura) {
//			struttura = (Struttura)o;
//			listSer.setStrutturaId(struttura);
//		}
		ListaServizio listSer = new ListaServizio();
		Annuncio annuncio = new Annuncio();
		annuncio.setId(7);
		Servizio servizio = serviceServizio.getById(1);
		listSer.setServizioId(servizio);
		listSer.setAnnuncioId(annuncio);
		//TODO prendere servizio/annuncio/struttura tramite i loro service
		serviceListaServizio.addListaServizio(listSer);
        return "mostralistaservizio";
    }
//	
//	@RequestMapping(value = "/eliminalistaservizio", method = RequestMethod.POST)
//    public String eliminaListaServizio(Model model, @RequestParam(name = "id") int servizioId) {
//        serviceServizio.removeServizio(servizioId);
//        return "eliminaservizio";
//    }
//	
//	@RequestMapping(value = "/eliminalistaservizio", method = RequestMethod.POST)
//    public String updateListaServizio(Model model, @RequestParam(name = "id") int servizioId, 
//    		@RequestParam(name = "nome" ) String nome, @RequestParam(name = "urlImg") String urlImg ) {
//		Servizio servizio = new Servizio();
//		servizio.setNome(nome);
//		servizio.setUrlImg(urlImg);
//        serviceServizio.updateServizio(servizio, servizioId);
//        return "updateservizio";
//    }
	
	
}
