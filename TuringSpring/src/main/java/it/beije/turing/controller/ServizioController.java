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

import it.beije.turing.beans.Servizio;
import it.beije.turing.service.ServizioService;



@RestController
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
	
	@PostMapping(value = "/addservice")
    public Servizio aggiungiServizio(@RequestBody Servizio servizio) {
        return serviceServizio.addServizio(servizio);
    }
	
	@DeleteMapping(value = "/delservice/{id}")
    public Map<String, Boolean> eliminaServizio(@PathVariable(name = "id") Integer id) {
        serviceServizio.removeServizio(id);
        
        Map map = new HashMap<String, Boolean>();
        map.put("esito", Boolean.TRUE);
        
        return map;
    }
	
	@PutMapping(value = "/updateservice{id}")
    public Servizio updateServizio(@PathVariable(name = "id") Integer id, @RequestBody Servizio servizio) {
        return serviceServizio.updateServizio(servizio, id);
    }
	
}
