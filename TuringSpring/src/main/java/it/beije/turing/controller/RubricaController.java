package it.beije.turing.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.turing.service.FirstService;


@Controller
public class RubricaController {
	

	@Autowired
	private FirstService service;
	
	

	
	
	@RequestMapping(value = "/insert_contatto", method = RequestMethod.GET)
	public String insertGet() {
		System.out.println("get /insert");
		
		return "insert_contatto";
	}
	
	@RequestMapping(value = "/insert_contatto", method = RequestMethod.POST)
	public String insertPost(Model model, 
			@RequestParam String nome, 
			@RequestParam String cognome,
			@RequestParam String email,
			@RequestParam String telefono,
			@RequestParam String note) {
		
		System.out.println("POST /login");
		
		System.out.println("nome:" + nome);
		System.out.println("cognome:" + cognome);
		System.out.println("telefono:" + telefono);
		System.out.println("email:" + email);
		System.out.println("note:" + note);
		
		model.addAttribute("nome", nome);
		model.addAttribute("cognome", cognome);
		model.addAttribute("email", email);
		model.addAttribute("telefono", telefono);
		model.addAttribute("note", note);
	
		
		return "myprofile";
		
	}
	

}
