package it.beije.turing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.beije.turing.service.ServiceCarta;

@Controller
public class CartaController {
	@Autowired
	private ServiceCarta serviceCarta;
}
