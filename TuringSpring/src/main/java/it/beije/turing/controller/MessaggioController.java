package it.beije.turing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.turing.service.ServiceMessaggio;
import it.beije.turing.beans.Messaggio;


@RestController
public class MessaggioController {
	
	@Autowired
	private ServiceMessaggio serviceMessaggio;
	
	
	@GetMapping(value = "/messages")
	public List<Messaggio> messaggi() {
		System.out.println("GET /messaggi " + this.toString());
		
		List<Messaggio> messaggi = serviceMessaggio.getAll();
		
		System.out.println(messaggi);
		
		return messaggi;
	}
	
	
	@GetMapping(value = "/messages/sender/{sender_id}")
	public List<Messaggio> messaggioBySender(@PathVariable(name = "sender_id") Integer senderId) {
		
		System.out.println("GET /messaggio/" + senderId);
		
		return serviceMessaggio.getBySenderId(senderId);
	
	}
	
	@GetMapping(value = "/messages/receiver/{receiver_id}")
	public List<Messaggio> messaggioByReceiver(@PathVariable(name = "receiver_id") Integer receiverId) {
		
		System.out.println("GET /messaggio/" + receiverId);
		
		return serviceMessaggio.getByReceiverId(receiverId);
	
	}
	
	@GetMapping(value = "/messages/annuncio/{annuncio_id}")
	public List<Messaggio> messaggioByAnnuncio(@PathVariable(name = "annuncio_id") Integer annuncioId) {
		
		System.out.println("GET /messaggio/" + annuncioId);
		
		return serviceMessaggio.getByAnnuncioId(annuncioId);
	
	}
	
	@PostMapping(value = "message")
	public Messaggio Messaggio(@RequestBody Messaggio messaggio) {
		System.out.println("POST /messaggio -> " + messaggio);
		
		if (messaggio.getTesto() != null && messaggio.getSenderId() != null && messaggio.getSenderId() != null) {
			serviceMessaggio.createMessaggio(messaggio);
		}
		
		return messaggio;
	}
	
	
	@DeleteMapping(value = "/message/{id}")
	public Map<String, Boolean> delMessage(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE /messsage/" + id);
		
		serviceMessaggio.deleteMessaggio(serviceMessaggio.getByMessaggioId(id));
		
		Map map = new HashMap<String, Boolean>();
		map.put("esito", Boolean.TRUE);
		
		return map;
	}
	
	
	
	
	

}
