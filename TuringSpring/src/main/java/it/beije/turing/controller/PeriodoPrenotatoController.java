package it.beije.turing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.turing.beans.PeriodoPrenotato;
import it.beije.turing.service.ServicePeriodoPrenotato;

@RestController
public class PeriodoPrenotatoController 
{
	@Autowired
	private ServicePeriodoPrenotato servicePp;
	
	@GetMapping(value = "/periodi_prenotati")
	public List<PeriodoPrenotato> contacts() {
		System.out.println("GET /periodi_prenotati " + this.toString());
		
		List<PeriodoPrenotato> periodiPrenotati = servicePp.getPeriodiPrenotati();
		
		return periodiPrenotati;
	}
	
	@GetMapping(value = "/periodo_prenotato/{id}")
	public PeriodoPrenotato contact(@PathVariable(name = "id") Integer id) {
		System.out.println("GET /periodo_prenotato/" + id);
		
		return servicePp.findPeriodoPrenotato(id);
	}

	@PostMapping(value = "/periodo_prenotato")
	public PeriodoPrenotato contact(@RequestBody PeriodoPrenotato periodoPrenotato) {
		System.out.println("POST /periodo_prenotato -> " + periodoPrenotato);
		
		return servicePp.newPeriodoPrenotato(periodoPrenotato);
	}

	@PutMapping(value = "/periodo_prenotato/{id}")
	public PeriodoPrenotato contact(@PathVariable(name = "id") Integer id, @RequestBody PeriodoPrenotato periodoPrenotato) {
		System.out.println("PUT /periodo_prenotato/ " + id + " -> " + periodoPrenotato);
		
		return servicePp.updatePeriodoPrenotato(periodoPrenotato, id);
	}
	
	@DeleteMapping(value = "/periodo_prenotato/{id}")
	public Map<String, Boolean> delContact(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE /periodo_prenotato/" + id);
		
		servicePp.deletePeriodoPrenotato(id);
		
		Map map = new HashMap<String, Boolean>();
		
		if(servicePp.findPeriodoPrenotato(id) == null) {			
			return (Map<String, Boolean>) map.put("esito", Boolean.TRUE);
		} else {
			return (Map<String, Boolean>) map.put("esito", Boolean.FALSE);
		}
	}
}
