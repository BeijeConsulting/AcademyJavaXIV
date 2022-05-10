package it.beije.turing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.turing.beans.Carta;
import it.beije.turing.service.ServiceCarta;

@RestController
public class CartaRestController {
	@Autowired
	private ServiceCarta serviceCarta;
	
	
	@GetMapping(value="/cards/{id}")
	public List<Carta> cards(@PathVariable(name = "id") Integer id){
		System.out.println("GET /cards " + this.toString());
		
		List<Carta> carte = serviceCarta.getByUtenteId(id);
		
		System.out.println(carte);
		
		return carte;
	}
	
	@PostMapping(value = "/card")
	public Carta card(@RequestBody Carta carta) {
		System.out.println("POST /card -> " + carta);
		
		if (carta.getNumeroCarta() != null && carta.getDataScadenza() != null) {
			Carta c = serviceCarta.addCarta(carta);
			System.out.println("POST /card -> c " + c);
			return c;
		}
		
		return carta;
	}
	
	@PutMapping(value = "/card/{id}")
	public Carta card(@PathVariable(name = "id") Integer id, @RequestBody Carta carta) {
		System.out.println("PUT /carta/ " + id + " -> " + carta);
		
		if (carta.getId().compareTo(id) == 0) {
			carta = serviceCarta.updateCarta(id, carta);
		}
		
		return carta;
	}
	
	@DeleteMapping(value = "/card/{id}")
	public Map<String, Boolean> delContact(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE /card/" + id);
		
		serviceCarta.removeCarta(serviceCarta.findCarta(id));
		
		Map map = new HashMap<String, Boolean>();
		map.put("esito", Boolean.TRUE);
		
		return map;
	}
}
