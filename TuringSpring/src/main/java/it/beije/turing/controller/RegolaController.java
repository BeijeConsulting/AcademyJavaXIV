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

import it.beije.turing.beans.ListaRegole;
import it.beije.turing.beans.Regola;
import it.beije.turing.service.ServiceListaRegole;
import it.beije.turing.service.ServiceRegola;

@RestController
public class RegolaController {

		@Autowired
		private ServiceRegola service;

		@GetMapping(value = "/regole")
		public List<Regola> listaRegole() {
			System.out.println("GET /lista_regole " + this.toString());
			
			List<Regola> rubrica = service.getRegola();
			
			System.out.println(rubrica);
			
			return rubrica;
		}

		@GetMapping(value = "/regole/{id}")
		public Regola contact(@PathVariable(name = "id") Integer id) {
			System.out.println("GET /contact/" + id);
			
			return service.getRegola(id);
		}

		@PostMapping(value = "/regole")
		public Regola contact(@RequestBody Regola Regola) {
			System.out.println("POST /contact -> " + Regola);
			
				return service.newRegola(Regola);
			
			
		}

		@PutMapping(value = "/regole/{id}")
		public Regola contact(@PathVariable(name = "id") Integer id, @RequestBody Regola Regola) {
			System.out.println("PUT /contact/ " + id + " -> " + Regola);
			
			if (Regola.getId().compareTo(id) == 0) {
				Regola=service.updateRegola(Regola, id);
			}
			
			return Regola;
		}
		
		@DeleteMapping(value = "/regole/{id}")
		public Map<String, Boolean> delContact(@PathVariable(name = "id") Integer id) {
			System.out.println("DELETE /contact/" + id);
			
			service.deleteRegola(id);
			
			Map map = new HashMap<String, Boolean>();
			map.put("esito", Boolean.TRUE);
			
			return map;
		}
}
