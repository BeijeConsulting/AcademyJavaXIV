package it.beije.turing.controller;

import it.beije.turing.beans.Utente;
import it.beije.turing.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UtenteController
{
	
	@Autowired
	private FirstService service;

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String index() {
//
//		return "index";
//	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registraUtente() {

		return "registrazione";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registraUtentePost(Model model,
									 @RequestParam(name = "fname") String fname,
									 @RequestParam(name = "lname") String lname,
									 @RequestParam(name = "email") String email,
									 @RequestParam(name = "password") String password,
									 @RequestParam(name = "date") String date,
									 @RequestParam(name = "cod_documenti") String cod_documenti,
									 @RequestParam(name = "telefono") String telefono,
									 @RequestParam(name = "tipo_utente") String tipo_utente
									 ) {



		return "registrazione_post";
	}
}