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
import it.beije.turing.service.ServiceListaRegole;

@RestController
public class ListaRegoleController {

		@Autowired
		private ServiceListaRegole service;

		@GetMapping(value = "/lista_regole")
		public List<ListaRegole> listaRegole() {
			System.out.println("GET /lista_regole " + this.toString());
			
			List<ListaRegole> rubrica = service.getListaRegole();
			
			System.out.println(rubrica);
			
			return rubrica;
		}

		@GetMapping(value = "/lista_regole/{id}")
		public ListaRegole contact(@PathVariable(name = "id") Integer id) {
			System.out.println("GET /contact/" + id);
			
			return service.getListaRegole(id);
		}

		@PostMapping(value = "/lista_regole")
		public ListaRegole contact(@RequestBody ListaRegole listaRegole) {
			System.out.println("POST /contact -> " + listaRegole);
			
				return service.newListaRegole(listaRegole);
			
			
		}

		@PutMapping(value = "/lista_regole/{id}")
		public ListaRegole contact(@PathVariable(name = "id") Integer id, @RequestBody ListaRegole listaRegole) {
			System.out.println("PUT /contact/ " + id + " -> " + listaRegole);
			
			if (listaRegole.getId().compareTo(id) == 0) {
				listaRegole=service.updateListaRegole(listaRegole, id);
			}
			
			return listaRegole;
		}
		
		@DeleteMapping(value = "/lista_regole/{id}")
		public Map<String, Boolean> delContact(@PathVariable(name = "id") Integer id) {
			System.out.println("DELETE /contact/" + id);
			
			service.deleteListaRegole(id);
			
			Map map = new HashMap<String, Boolean>();
			map.put("esito", Boolean.TRUE);
			
			return map;
		}
}
