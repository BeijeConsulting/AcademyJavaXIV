//package it.beije.turing.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import it.beije.turing.example.Contatto;
//import it.beije.turing.service.FirstService;
//
//
//@Controller
//public class SecondController {
//	
//	@Autowired
//	private FirstService service;
//
//	@RequestMapping(value = "/elenco", method = RequestMethod.GET)
//	public String elenco(Model model) {
//		System.out.println("GET /elenco " + this.toString());
//		
//		List<Contatto> rubrica = service.leggiRubrica();
//		
//		model.addAttribute("contatti", rubrica);
//		
//		return "elenco";
//	}
//	
////	@RequestMapping(value = "/elenco_rest", method = RequestMethod.GET)
////	public @ResponseBody List<Contatto> elencoRest(Model model) {
////		System.out.println("GET /elenco_rest " + this.toString());
////		
////		List<Contatto> rubrica = service.leggiRubrica();
////		
////		System.out.println(rubrica);
////		
////		//model.addAttribute("contatti", rubrica);
////		
////		return rubrica;
////	}
//	
//	@RequestMapping(value = "/elenco_mail", method = RequestMethod.GET)
//	public String elencoMail(Model model) {
//		System.out.println("GET /elenco_mail");
//		
//		service.leggiRubrica();
//		model.addAttribute("contatti", new ArrayList());
//				
//		return "elenco";
//	}
//
//}
