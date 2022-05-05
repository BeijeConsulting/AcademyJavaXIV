package it.beije.turing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.turing.service.FirstService;


@Controller
public class FirstController
{

	@Autowired
	private FirstService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		System.out.println("GET / " + this.toString());
		//...

		//service.leggiAnnunci();
		return "index";
	}
}