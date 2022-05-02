package it.beije.turing.controller;

import it.beije.turing.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.turing.service.RCViewer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URI;
import java.util.List;

@Controller
public class FirstController {
	
	@Autowired
	private FirstService service;
	private RCViewer serviceView;
	private RCInsert serviceInsert;
	private RCDelete serviceDelete;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/viewer", method = RequestMethod.GET)
	public String viewerGet() {
		return "viewer_form";
	}
	
	@RequestMapping(value = "/viewer", method = RequestMethod.POST)
	public String viewerPost(Model model, @RequestParam String order) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TuringSpring");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Contatto> contatti = serviceView.view(entityManager, order);
		model.addAttribute("contatti",contatti);
		return "view_contatto";
	}

	@RequestMapping(value = "/inserter", method = RequestMethod.GET)
	public String inserterGet() {
		return "inserter_form";
	}

	@RequestMapping(value = "/inserter", method = RequestMethod.POST)
	public String inserterPost(Model model, @RequestParam String name, @RequestParam String surname,
							   @RequestParam String email, @RequestParam String phone, @RequestParam String notes) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TuringSpring");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Contatto contatto = new Contatto();
		contatto.setCognome(surname);
		contatto.setNome(name);
		contatto.setEmail(email);
		contatto.setTelefono(phone);
		contatto.setNote(notes);
		serviceInsert.insert(entityManager, contatto);
		model.addAttribute("contatto", contatto);
		return "insert_contatto";
	}

	@RequestMapping(value = "/editor", method = RequestMethod.GET)
	public String editorGet(Model model) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TuringSpring");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		List<Contatto> contatti = serviceView.view(entityManager, "name");
		model.addAttribute("contatti",contatti);
		return "edit_contatto";
	}

	@RequestMapping(value = "/editor", method = RequestMethod.POST)
	public String editorPost(Model model, @RequestParam String contactId) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TuringSpring");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		RCDelete.delete(entityManager,contactId);
		List<Contatto> contatti = serviceView.view(entityManager, "name");
		model.addAttribute("contatti",contatti);
		return "edit_contatto";
		}


}
