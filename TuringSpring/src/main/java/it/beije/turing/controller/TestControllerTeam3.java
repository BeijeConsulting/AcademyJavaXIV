package it.beije.turing.controller;


	import it.beije.turing.beans.Annuncio;
	import it.beije.turing.beans.FotoAnnuncio;
	import it.beije.turing.beans.Immagine;
	import it.beije.turing.beans.ListaRegole;
	import it.beije.turing.beans.PeriodoPrenotato;
	import it.beije.turing.beans.Regola;
	import it.beije.turing.beans.Struttura;
	import it.beije.turing.repository.AnnuncioRepository;
	import it.beije.turing.service.FirstService;
	import it.beije.turing.service.ServiceStrutture;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;

	import java.time.LocalDate;
	import java.util.List;

	@Controller
	public class TestControllerTeam3 {

	    @Autowired
	    private FirstService service;

	    @RequestMapping(value = "/team3", method = RequestMethod.GET)
	    public String loginGet() {
	        
	    	
//	    	System.out.println("ANNUNCIO");
//	        service.getAnnuncio().forEach(System.out::println);
//	        Annuncio annuncio = new Annuncio();
//	        annuncio.setDescrizione("Descrizione");
//	        annuncio.setNumPostiLetto(5);
//	        annuncio.setPrezzo(1.0);
//	        annuncio.setStrutturaId(null);
//	        annuncio.setTitolo("titolo");
//	        service.newAnnuncio(annuncio);
//	        System.out.println("CREAZIONE");
//	        service.getAnnuncio().forEach(System.out::println);
//	        System.out.println("MODIFICA");
//	        annuncio=service.getAnnuncio().get(0);
//	        annuncio.setDescrizione("MODIFICA!");
//	        service.updateAnnuncio(annuncio,annuncio.getId());
//	        service.getAnnuncio().forEach(System.out::println);
//	        System.out.println("DELETE");
//	        service.deleteAnnuncio(annuncio.getId());
//	        service.getAnnuncio().forEach(System.out::println);
	        
//	        System.out.println("FOTOANNUNCIO");
//	        service.getFotoAnnuncio().forEach(System.out::println);
//	        FotoAnnuncio annuncio = new FotoAnnuncio();
//	        annuncio.setAnnuncio(service.getAnnuncio().get(0));
//	        annuncio.setImmagineId(null);
//	        service.newFotoAnnuncio(annuncio);
//	        System.out.println("CREAZIONE");
//	        service.getFotoAnnuncio().forEach(System.out::println);
//	        System.out.println("MODIFICA");
//	        annuncio=service.getFotoAnnuncio().get(0);
//	        annuncio.setAnnuncio(service.getAnnuncio().get(1));
//	        service.updateFotoAnnuncio(annuncio,annuncio.getId());
//	        service.getFotoAnnuncio().forEach(System.out::println);
//	        System.out.println("DELETE");
//	        //service.deleteFotoAnnuncio(annuncio.getId());
//	        service.getFotoAnnuncio().forEach(System.out::println);
	    	
	    	
	  	
//	    	 System.out.println("REGOLA");
//	         service.getRegola().forEach(System.out::println);
//	         Regola annuncio = new Regola();
//	         annuncio.setDescrizione("Descrizione");
//	         annuncio.setTitolo("Titolo");
//	         service.newRegola(annuncio);
//	         System.out.println("CREAZIONE");
//	         service.getRegola().forEach(System.out::println);
//	         System.out.println("MODIFICA");
//	         annuncio=service.getRegola().get(0);
//	         annuncio.setDescrizione("MODIFICA!");
//	         service.updateRegola(annuncio);
//	         service.getRegola().forEach(System.out::println);
//	         System.out.println("DELETE");
//	         service.deleteFotoAnnuncio(annuncio.getId());
//	         service.getRegola().forEach(System.out::println);
	         
//	       System.out.println("LISTA REGOLE");
//	       service.getListaRegole().forEach(System.out::println);
//	       ListaRegole annuncio = new ListaRegole();
//	       annuncio.setAnnuncioId(service.getAnnuncio().get(0));
//	       annuncio.setRegolaId(service.getRegola().get(0));
//	       annuncio.setCompletamento("Completamento");
//	       service.newListaRegole(annuncio);
//	       System.out.println("CREAZIONE");
//	       service.getListaRegole().forEach(System.out::println);
//	       System.out.println("MODIFICA");
//	       annuncio=service.getListaRegole().get(0);
//	       annuncio.setCompletamento("MODIFICA!");
//	       service.updateListaRegole(annuncio, annuncio.getId());
//	       service.getListaRegole().forEach(System.out::println);
//	       System.out.println("DELETE");
//	       service.deleteListaRegole(annuncio.getId());
//	       service.getFotoAnnuncio().forEach(System.out::println);
//	       
	       System.out.println("PERIODI PRENOTATI");
	       service.getPeriodiPrenotati().forEach(System.out::println);
	       PeriodoPrenotato annuncio = new PeriodoPrenotato();
	       annuncio.setAnnuncio(service.getAnnuncio().get(0));
	       annuncio.setDataInizio(LocalDate.now());
	       annuncio.setDataFine(LocalDate.now().plusDays(2));
	       annuncio.setStatoAccettazione("ACCETTATO");
	       annuncio.setStatoPagamento("ACCETTATO");
	       service.newPeriodoPrenotato(annuncio);
	       System.out.println("CREAZIONE");
	       service.getPeriodiPrenotati().forEach(System.out::println);
	       System.out.println("MODIFICA");
	       annuncio=service.getPeriodiPrenotati().get(0);
	       annuncio.setDataFine(LocalDate.now().plusYears(1));
	       service.updatePeriodoPrenotato(annuncio,annuncio.getId());
	       service.getPeriodiPrenotati().forEach(System.out::println);
	       System.out.println("DELETE");
	       service.deletePeriodoPrenotato(annuncio.getId());
	       service.getPeriodiPrenotati().forEach(System.out::println);
	        
	        return "index";
	    }

	}


