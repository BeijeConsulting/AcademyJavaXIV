package it.beije.turing.controller;

import it.beije.turing.beans.Utente;
import it.beije.turing.service.ServiceUtente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "api")
@RestController
public class UtenteRestController {
	
	@Autowired
	private ServiceUtente serviceUtente;

	@GetMapping(value = "/users")
	public List<Utente> users() {

		List<Utente> users = serviceUtente.getUsers();

		return users;
	}

	@GetMapping(value = "/user/{id}")
	public Utente user(@PathVariable(name = "id") Integer id) {

		return serviceUtente.getUtenteById(id);
	}

	@PostMapping(value = "/user")
	public Utente user(@RequestBody Utente user) {

		user = serviceUtente.createUser(user);

		return user;
	}

	@PutMapping(value = "/user/{id}")
	public Utente user(@PathVariable(name = "id") Integer id, @RequestBody Utente user) {

		if (user.getId().compareTo(id) == 0) {
			return serviceUtente.modificaUtente(id, user);
		}

		return null;
	}

	@DeleteMapping(value = "/user/{id}")
	public void deleteUser(@PathVariable(name = "id") Integer id) {

		serviceUtente.deleteUtente(id);
	}

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String index() {
//
//		return "index";
//	}

//	@RequestMapping(value = "/register", method = RequestMethod.GET)
//	public String registraUtente() {
//
//		return "registrazione";
//	}
//
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public String registraUtentePost(Model model,
//									 @RequestParam(name = "fname") String fname,
//									 @RequestParam(name = "lname") String lname,
//									 @RequestParam(name = "email") String email,
//									 @RequestParam(name = "password") String password) {
//
//		Utente newUtente = serviceUtente.creaUtente(fname, lname, email, password);
//
//		if (newUtente == null) return "index";
//		else {
//			model.addAttribute("utente", newUtente);
//			model.addAttribute("messaggio", "Utente registrato");
//			return "esito_operazione";
//		}
//	}
//
//	@RequestMapping(value = "/cerca", method = RequestMethod.GET)
//	public String cercaUtente() {
//
//		return "cerca";
//	}
//
//	@RequestMapping(value = "/cerca_delete", method = RequestMethod.GET)
//	public String cercaUtenteToDelete() {
//
//		return "cerca_per_delete";
//	}
//
//	@RequestMapping(value = "/cerca", method = RequestMethod.POST)
//	public String cercaUtentePost(Model model, @RequestParam(name = "email") String email) {
//
//		Utente utente = serviceUtente.getUtenteByEmail(email);
//
//		if (utente == null) return "index";
//		else {
//			model.addAttribute("utente", utente);
//			return "modifica_utente";
//		}
//	}
//
//	@RequestMapping(value = "/modifica", method = RequestMethod.POST)
//	public String modificaUtente(Model model,
//								 @RequestParam(name = "id") String id,
//								 @RequestParam(name = "fname") String fname,
//								 @RequestParam(name = "lname") String lname,
//								 @RequestParam(name = "email") String email,
//								 @RequestParam(name = "password") String password) {
//
//
//		Utente utenteModificato = serviceUtente.modificaUtente(id, fname, lname, email, password);
//
//		if (utenteModificato == null) return "index";
//		else {
//			model.addAttribute("utente", utenteModificato);
//			model.addAttribute("messaggio", "Utente aggiornato");
//			return "esito_operazione";
//		}
//	}
//
//	@RequestMapping(value = "/delete", method = RequestMethod.POST)
//	public String deleteUtente(Model model, @RequestParam(name = "email") String email) {
//
//		Utente utente = serviceUtente.getUtenteByEmail(email);
//
//		if (utente == null) return "index";
//		else {
//			serviceUtente.deleteUtente(utente);
//			model.addAttribute("messaggio", "Utente eliminato");
//
//			return "esito_operazione";
//		}
//
//	}
}