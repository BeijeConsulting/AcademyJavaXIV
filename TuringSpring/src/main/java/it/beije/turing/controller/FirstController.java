//package it.beije.turing.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import it.beije.turing.service.FirstService;
//
//
//@Controller
//public class FirstController {
//	
//	@Autowired
//	private FirstService service;
//	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String index() {
//		System.out.println("GET / " + this.toString());
//		//...
//		
//		service.leggiRubrica();
//		
//		return "index";
//	}
//
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String loginGet() {
//		System.out.println("GET /login");
//		//...
//		return "login";
//	}
//	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String loginPost(Model model, @RequestParam(name = "username") String username,
//			@RequestParam(name = "password", required = false) String password) {
//		System.out.println("POST /login");
//		
//		//String username = request.getParameter("username");
//		//String password = request.getParameter("password");
//		System.out.println("username: " + username);
//		System.out.println("password: " + password);
//		
//		model.addAttribute("username", username);
//		model.addAttribute("password", password);
//		
//		return "myprofile";
//	}
//	
//}
