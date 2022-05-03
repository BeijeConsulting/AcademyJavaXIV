package it.beije.turing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.turing.Contatto;
import it.beije.turing.service.JPAmanagerService;

@Controller
public class InsertController {
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertGet() {
		return "insert";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertPost(@RequestParam String name, @RequestParam String surname, @RequestParam String address, @RequestParam String birthday, @RequestParam String email, @RequestParam String phone, @RequestParam String notes) {
		Contatto contatto = new Contatto();
		
		contatto.setNome(name.trim());
		contatto.setCognome(surname.trim());
		contatto.setIndirizzo(address.trim());
		contatto.setDataDiNascita(birthday.trim());
		contatto.setEmail(email.trim());
		contatto.setTelefono(phone.trim());
		contatto.setNote(notes.trim());
		
		if(contatto.getNome().equals("") && contatto.getCognome().equals("") && contatto.getTelefono().equals("") && contatto.getEmail().equals("") && contatto.getDataDiNascita().equals("") && contatto.getIndirizzo().equals("") && contatto.getNote().equals("")) {
			return "home";
		} else {			
			JPAmanagerService.insertToRubrica(contatto);
			
			return "home";
		}
	}
}
