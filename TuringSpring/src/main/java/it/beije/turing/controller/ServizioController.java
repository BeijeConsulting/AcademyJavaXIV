package it.beije.turing.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.turing.beans.Servizio;
import it.beije.turing.service.ServizioService;

@Controller
public class ServizioController {
	
	@Autowired
	private ServizioService serviceServizio;
	
	
	@GetMapping(value = "/services")
	public List<Servizio> mostraServizi() {
		System.out.println("SERVIZIO");
		List<Servizio> services = serviceServizio.getAllServizio();
		System.out.println(services);
		return services;
	}
	
	@RequestMapping(value = "/aggiungiservizio", method = RequestMethod.GET)
    public String aggiungiServizio(Model model, @RequestParam(name = "nome" ) String nome, @RequestParam(name = "urlImg") String urlImg) {
		nome = "ciao";
		urlImg = "aggiunto";
		serviceServizio.addServizio(urlImg, nome);
        return "aggiungiservizio";
    }
	
	@RequestMapping(value = "/eliminaservizio", method = RequestMethod.GET)
    public String eliminaServizio(Model model, @RequestParam(name = "id") int servizioId) {
        serviceServizio.removeServizio(servizioId);
        return "eliminaservizio";
    }
	
	@RequestMapping(value = "/updateservizio", method = RequestMethod.GET)
    public String updateServizio(Model model, @RequestParam(name = "id") int servizioId, 
    		@RequestParam(name = "nome" ) String nome, @RequestParam(name = "urlImg") String urlImg ) {
		Servizio servizio = new Servizio();
		servizio.setNome(nome);
		servizio.setUrlImg(urlImg);
        serviceServizio.updateServizio(servizio, servizioId);
        return "updateservizio";
    }
	
}
