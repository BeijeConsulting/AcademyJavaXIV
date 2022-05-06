package it.beije.turing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import it.beije.turing.service.ServiceMessaggio;


@Controller
public class MessaggioController {
	
	@Autowired
	private ServiceMessaggio serviceMessaggio;

}
