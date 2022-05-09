package it.beije.turing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
>>>>>>> origin/main
import org.springframework.web.bind.annotation.RestController;

import it.beije.turing.rubrica.bean.Contatto;
import it.beije.turing.service.GestoreRubrica;


//@RequestMapping(value = "api")
@RestController
public class RestSecondController {

	@Autowired
	private GestoreRubrica service;

	//@RequestMapping(value = "/elenco_rest", method = RequestMethod.GET)
	@GetMapping(value = "/contacts")
	public List<Contatto> contacts() {
		System.out.println("GET /contacts " + this.toString());
		
		List<Contatto> rubrica = service.getList();
		
		System.out.println(rubrica);
		
		return rubrica;
	}

	@GetMapping(value = "/contact/{id}")
	public Contatto contact(@PathVariable(name = "id") Integer id) {
		System.out.println("GET /contact/" + id);
		
		return service.findContatto(id);
	}

	@PostMapping(value = "/contact")
	public Contatto contact(@RequestBody Contatto contatto) {
		System.out.println("POST /contact -> " + contatto);
		
		if (contatto.getNome() != null || contatto.getCognome() != null) {
			service.insertContatto(contatto);
		}
		
		return contatto;
	}

	@PutMapping(value = "/contact/{id}")
	public Contatto contact(@PathVariable(name = "id") Integer id, @RequestBody Contatto contatto) {
		System.out.println("PUT /contact/ " + id + " -> " + contatto);
		
		if (contatto.getId().compareTo(id) == 0) {
			service.updateContatto(id, contatto);
		}
		
		return contatto;
	}
	
	@DeleteMapping(value = "/contact/{id}")
	public Map<String, Boolean> delContact(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE /contact/" + id);
		
		service.deleteContatto(id);
		
		Map map = new HashMap<String, Boolean>();
		map.put("esito", Boolean.TRUE);
		
		return map;
	}

	
	// /products?category=xxx&subcategory=yyy
	// /products/category/{category}/subcategory/{subcategory}

	// GET /struttura/{id}/stanze
	
}
