package it.beije.turing.controller;

import it.beije.turing.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
	public String registraUtentePost() {

		return "registrazione_post";
	}
}