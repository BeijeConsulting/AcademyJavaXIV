package it.beije.turing.rubrica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.turing.rubrica.Contatto;
import it.beije.turing.rubrica.service.RubricaManager;
@Controller
public class MyController {
	@Autowired
	private RubricaManager rm;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "print", method = RequestMethod.GET)
	public String printGet() {
		return "print_get";
	}
	@RequestMapping(value = "print", method = RequestMethod.POST)
	public String printPost(Model model,@RequestParam(name="type", required=false) String type) {
		if(type == null) {
			type = "N";
		}else if(type.equalsIgnoreCase("name")) {
			type = "N";
		}else {
			type = "S";
		}
		List<Contatto> list = rm.printAllContatti(type);
		model.addAttribute("contatti", list);
		return "print_post";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String searchGet() {
		return "search_get";
	}
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String searchPost() {
		return "search_post";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addGet() {
		return "add_get";
	}
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addPost(@RequestParam(name="name", required=false) String name,@RequestParam(name="lname", required=false) String lname,
			@RequestParam(name="tel", required=false) String tel, @RequestParam(name="email", required=false) String email, 
			@RequestParam(name="note", required=false) String note, Model model) {
		Contatto c = rm.AggiungiContatto(name, lname, tel, email, note);
		if(c == null)
			return "add_get";
		model.addAttribute("contatto",c);
		return "add_post";
	}
	
	@RequestMapping(value = "remove", method = RequestMethod.GET)
	public String removeGet() {
		return "remove_get";
	}
	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public String removePost() {
		return "remove_post";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String modifyGet(Model model) {
		List<Contatto> list = rm.printAllContatti();
		model.addAttribute("contatti",list);
		return "modify_get";
	}
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modifyPost(@RequestParam(name="id", required=false) String id,@RequestParam(name="name", required=false) String name,@RequestParam(name="lname", required=false) String lname,
			@RequestParam(name="tel", required=false) String tel, @RequestParam(name="email", required=false) String email, 
			@RequestParam(name="note", required=false) String note, Model model) {
		Contatto c = new Contatto();
		try {
			c.setId(Integer.parseInt(id));
		}catch(NumberFormatException nfEx) {
			return "modify_get";
		}
		c.setCognome(lname);
		c.setNome(name);
		c.setEmail(email);
		c.setTelefono(tel);
		c.setNote(note);
		Contatto tmp = rm.ModificaContatto(c);
		if(tmp == null)
			return "/";
		model.addAttribute("contatto",tmp);
		return "modify_post";
	}
	
	@RequestMapping(value = "duplicate", method = RequestMethod.GET)
	public String duplicate() {
		return "duplicate";
	}
}
