package it.beije.turing.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value = "/aggiungiservizio", method = RequestMethod.GET)
    public String aggiungiServizio(Model model, @RequestParam(name = "nome" ) String nome, @RequestParam(name = "urlImg") String urlImg) {
		serviceServizio.addServizio(urlImg, nome);
        return "inserisciimmagine";
    }
	
	@RequestMapping(value = "/eliminaservizio", method = RequestMethod.POST)
    public String eliminaServizio(Model model, @RequestParam(name = "id") int servizioId) {
        serviceServizio.removeServizio(servizioId);
        return "eliminaservizio";
    }
	
	@RequestMapping(value = "/eliminaservizio", method = RequestMethod.POST)
    public String updateServizio(Model model, @RequestParam(name = "id") int servizioId, 
    		@RequestParam(name = "nome" ) String nome, @RequestParam(name = "urlImg") String urlImg ) {
		Servizio servizio = new Servizio();
		servizio.setNome(nome);
		servizio.setUrlImg(urlImg);
        serviceServizio.updateServizio(servizio, servizioId);
        return "updateservizio";
    }
	
}
