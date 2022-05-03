package it.beije.turing.controller;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.turing.Contatto;
import it.beije.turing.service.JPAentityManagerFactoryService;
import it.beije.turing.service.JPAmanagerService;

@Controller
public class DeleteController {
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteGet(Model model, @RequestParam(name = "id") String idS) {
		int id = Integer.parseInt(idS);
		EntityManager entityManager = JPAentityManagerFactoryService.openEntityManager();
		Contatto contatto = entityManager.find(Contatto.class, id);
		
		model.addAttribute("contatto", contatto);
		model.addAttribute("id", Integer.toString(id));
		
		return "delete";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletePost(@RequestParam(name = "id") String idS) {
		int id = Integer.parseInt(idS);
		
		JPAmanagerService.deleteContattoRubrica(id);
		
		return "home";
	}
}
