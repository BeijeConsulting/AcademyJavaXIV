package it.beije.turing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.turing.service.GestoreRubrica;


@Controller
public class MainController {
	
	@Autowired
	private GestoreRubrica service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Main(Model model) {
		model.addAttribute("contatti", service.getList());
		
		
		return "main";
	}

	@RequestMapping(value = "/addContatto", method = RequestMethod.POST)
	public String addContatto(Model model,@RequestParam(name = "nome") String nome,@RequestParam(name = "cognome") String cognome,
	@RequestParam(name = "email") String email,@RequestParam(name = "telefono") String telefono) {
		
		service.add(nome, cognome, telefono, email,"");
		model.addAttribute("contatti", service.getList());
		return "main";
	}
	

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String addContatto(Model model,@RequestParam(name="id") String id) {
		service.delete(id);
		model.addAttribute("contatti", service.getList());
		
		return "main";
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateContatto(Model model,@RequestParam(name = "id") String id,@RequestParam(name = "nome") String nome,
			@RequestParam(name = "cognome") String cognome,
	@RequestParam(name = "email") String email,@RequestParam(name = "telefono") String telefono) {
		service.modify(Integer.parseInt(id),nome, cognome, telefono, email,"");
		model.addAttribute("contatti", service.getList());
		return "main";
	}
	
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchContatto(Model model,@RequestParam(name = "id") String id,@RequestParam(name = "nome") String nome,
			@RequestParam(name = "cognome") String cognome,
	@RequestParam(name = "email") String email,@RequestParam(name = "telefono") String telefono) {
		StringBuilder builder = new StringBuilder();	
		if(id!=null&&id!="")
		{
			builder.append(" id"+" "+id);
		}
		if(nome!=null&&nome!="")
		{
			builder.append(" nome"+" "+nome);
		}
		if(cognome!=null&&cognome!="")
		{
			builder.append(" cognome"+" "+cognome);
		}
		if(email!=null&&email!="")
		{
			builder.append(" email"+" "+email);
		}
		if(telefono!=null&&telefono!="")
		{
			builder.append(" telefono"+" "+telefono);
		}
		
		
		model.addAttribute("contatti", service.search(builder.substring(1).split(" ")) );
		
		
		return "main";
	}
	
	
	
	@RequestMapping(value = "/duplicates", method = RequestMethod.GET)
	public String findDupes(Model model) {
		model.addAttribute("contatti", service.findDuplicates());
		
		return "main";
	}
}
