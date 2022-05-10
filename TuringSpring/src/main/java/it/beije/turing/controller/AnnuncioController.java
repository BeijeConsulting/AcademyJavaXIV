package it.beije.turing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.turing.beans.Annuncio;
import it.beije.turing.service.ServiceAnnuncio;

@RestController
public class AnnuncioController
{
	@Autowired
	private ServiceAnnuncio serviceAnnuncio;
	
	
	@GetMapping(value = "/annunci")
	public List<Annuncio> annunci()
	{
		System.out.println("GET /contacts " + this.toString());
		
		List<Annuncio> annunci = serviceAnnuncio.getAnnuncio();
		
		System.out.println(annunci);
		
		return annunci;
	}

	@GetMapping(value = "/annuncio/{id}")
	public Optional<Annuncio> annuncio(@PathVariable(name = "id") Integer id)
	{
		System.out.println("GET /annuncio/" + id);
		
		return serviceAnnuncio.findAnnuncio(id);
	}

	@PostMapping(value = "/annuncio")
	public Annuncio annuncio(@RequestBody Annuncio annuncio)
	{
		System.out.println("POST /annuncio -> " + annuncio);
		
		return serviceAnnuncio.newAnnuncio(annuncio);
	}

	@PutMapping(value = "/annuncio/{id}")
	public Annuncio annuncio(@PathVariable(name = "id") Integer id, @RequestBody Annuncio annuncio)
	{
		System.out.println("PUT /annuncio/ " + id + " -> " + annuncio);
		
		if (annuncio.getId().compareTo(id) == 0)
		{
			return serviceAnnuncio.updateAnnuncio(annuncio, id);
		}
		
		return null;
	}
	
	@DeleteMapping(value = "/annuncio/{id}")
	public Map<String, Boolean> delAnnuncio(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE /annuncio/" + id);
		
		serviceAnnuncio.deleteAnnuncio(id);
		
		Map map = new HashMap<String, Boolean>();
		map.put("esito", Boolean.TRUE);
		
		return map;
	}
}