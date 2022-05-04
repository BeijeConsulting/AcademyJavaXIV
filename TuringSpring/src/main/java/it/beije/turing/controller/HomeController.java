package it.beije.turing.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.turing.Contatto;
import it.beije.turing.service.JPAhandler;

@Controller
public class HomeController {
	
	@Autowired
	private JPAhandler jpaHandler;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome()
	{		
		return "index";
	}
	
	@RequestMapping(value = "/getRubrica", method = RequestMethod.POST)
	public String getRubrica(Model model)
	{
		model.addAttribute("contatti", jpaHandler.getRubrica());
		
		return "index";
	}

	@RequestMapping(value = "/findDuplicates", method = RequestMethod.POST)
	public String findDuplicates(Model model)
	{
		model.addAttribute("contatti", jpaHandler.findDuplicates());
		
		return "index";
	}
	
	@RequestMapping(value = "/uniteDuplicates", method = RequestMethod.POST)
	public String uniteDuplicates(Model model)
	{
		jpaHandler.uniteDuplicates();
		model.addAttribute("contatti", jpaHandler.getRubrica());
		
		return "index";
	}
	
	@RequestMapping(value = "/findContact", method = RequestMethod.POST)
	public String findContact(HttpServletRequest request, Model model)
	{
		model.addAttribute("contatti", jpaHandler.findContatto(request.getParameter("filtro")));
		
		return "index";
	}
	
	@RequestMapping(value = "/modifyContact", method = RequestMethod.POST)
	public String modifyContact(HttpServletRequest request, Model model)
	{
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String note = request.getParameter("note");
		
		Contatto contatto = new Contatto(nome, cognome, email, telefono, note);
		
		jpaHandler.modifyContatto(Integer.parseInt(request.getParameter("indice")), contatto);
		
		model.addAttribute("contatti", jpaHandler.getRubrica());
		
		return "index";
	}
	
	@RequestMapping(value = "/deleteContact", method = RequestMethod.POST)
	public String deleteContact(HttpServletRequest request, Model model)
	{
		jpaHandler.deleteContatto(Integer.parseInt(request.getParameter("indice")));
		
		model.addAttribute("contatti", jpaHandler.getRubrica());
		
		return "index";
	}
	
	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(HttpServletRequest request, Model model)
	{
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String note = request.getParameter("note");
		
		Contatto newContatto = new Contatto(nome, cognome, email, telefono, note);
		jpaHandler.addContatto(newContatto);
		
		model.addAttribute("contatti", jpaHandler.getRubrica());
		
		return "index";
	}
}