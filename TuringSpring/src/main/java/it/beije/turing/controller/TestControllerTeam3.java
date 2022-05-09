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
import it.beije.turing.service.ServiceAnnuncio;
import it.beije.turing.service.ServiceFotoAnnuncio;
import it.beije.turing.service.ServiceListaRegole;
import it.beije.turing.service.ServicePeriodoPrenotato;
import it.beije.turing.service.ServiceRegola;
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
	    private ServiceAnnuncio serviceann;
	    
	    @Autowired
	    private ServiceFotoAnnuncio servicefotann;
	    @Autowired
	    private ServiceRegola servicereg;
	    @Autowired
	    private ServiceListaRegole servicelistreg;
	    @Autowired
	    private ServicePeriodoPrenotato serviceperiod;

	    @RequestMapping(value = "/team3", method = RequestMethod.GET)
	    public String loginGet() {
	        
	    	
	    	System.out.println("ANNUNCIO");
	        serviceann.getAnnuncio().forEach(System.out::println);
	        Annuncio annuncio = new Annuncio();
	        annuncio.setDescrizione("Descrizione");
	        annuncio.setNumPostiLetto(5);
	        annuncio.setPrezzo(1.0);
	        annuncio.setStrutturaId(null);
	        annuncio.setTitolo("titolo");
	        serviceann.newAnnuncio(annuncio);
	        System.out.println("CREAZIONE");
	        serviceann.getAnnuncio().forEach(System.out::println);
	        System.out.println("MODIFICA");
	        annuncio=serviceann.getAnnuncio().get(0);
	        annuncio.setDescrizione("MODIFICA!");
	        serviceann.updateAnnuncio(annuncio,annuncio.getId());
	        serviceann.getAnnuncio().forEach(System.out::println);
	        System.out.println("DELETE");
	        serviceann.deleteAnnuncio(annuncio.getId());
	        serviceann.getAnnuncio().forEach(System.out::println);
	        
	        System.out.println("FOTOANNUNCIO");
	        servicefotann.getFotoAnnuncio().forEach(System.out::println);
	        FotoAnnuncio fotannuncio = new FotoAnnuncio();
	        fotannuncio.setAnnuncio(serviceann.getAnnuncio().get(0));
	        fotannuncio.setImmagineId(null);
	        servicefotann.newFotoAnnuncio(fotannuncio);
	        System.out.println("CREAZIONE");
	        servicefotann.getFotoAnnuncio().forEach(System.out::println);
	        System.out.println("MODIFICA");
	        fotannuncio=servicefotann.getFotoAnnuncio().get(0);
	        fotannuncio.setAnnuncio(serviceann.getAnnuncio().get(1));
	        servicefotann.updateFotoAnnuncio(fotannuncio,fotannuncio.getId());
	        servicefotann.getFotoAnnuncio().forEach(System.out::println);
	        System.out.println("DELETE");
	        //servicefotann.deleteFotoAnnuncio(fotannuncio.getId());
	        servicefotann.getFotoAnnuncio().forEach(System.out::println);
	    	
	    	
	  	
	    	 System.out.println("REGOLA");
	         servicereg.getRegola().forEach(System.out::println);
	         Regola regola = new Regola();
	         regola.setDescrizione("Descrizione");
	         regola.setTitolo("Titolo");
	         servicereg.newRegola(regola);
	         System.out.println("CREAZIONE");
	         servicereg.getRegola().forEach(System.out::println);
	         System.out.println("MODIFICA");
	         regola=servicereg.getRegola().get(0);
	         regola.setDescrizione("MODIFICA!");
	         //servicereg.updateRegola(regola);
	         servicereg.getRegola().forEach(System.out::println);
	         System.out.println("DELETE");
	        // servicereg.deleteRegola(regola);
	         servicereg.getRegola().forEach(System.out::println);
	         
	       System.out.println("LISTA REGOLE");
	       servicelistreg.getListaRegole().forEach(System.out::println);
	       ListaRegole listaRegola = new ListaRegole();
	       listaRegola.setAnnuncioId(serviceann.getAnnuncio().get(0));
	       listaRegola.setRegolaId(servicereg.getRegola().get(0));
	       listaRegola.setCompletamento("Completamento");
	       servicelistreg.newListaRegole(listaRegola);
	       System.out.println("CREAZIONE");
	       servicelistreg.getListaRegole().forEach(System.out::println);
	       System.out.println("MODIFICA");
	       listaRegola=servicelistreg.getListaRegole().get(0);
	       listaRegola.setCompletamento("MODIFICA!");
	       servicelistreg.updateListaRegole(listaRegola, listaRegola.getId());
	       servicelistreg.getListaRegole().forEach(System.out::println);
	       System.out.println("DELETE");
	       servicelistreg.deleteListaRegole(listaRegola.getId());
	       servicelistreg.getListaRegole().forEach(System.out::println);
	    	
	    	
	       
	       System.out.println("PERIODI PRENOTATI");
	       serviceperiod.getPeriodiPrenotati().forEach(System.out::println);
	       PeriodoPrenotato periodo = new PeriodoPrenotato();
	       periodo.setAnnuncio(serviceann.getAnnuncio().get(0));
	       periodo.setDataInizio(LocalDate.now());
	       periodo.setDataFine(LocalDate.now().plusDays(2));
	       periodo.setStatoAccettazione("ACCETTATO");
	       periodo.setStatoPagamento("ACCETTATO");
	       serviceperiod.newPeriodoPrenotato(periodo);
	       System.out.println("CREAZIONE");
	       serviceperiod.getPeriodiPrenotati().forEach(System.out::println);
	       System.out.println("MODIFICA");
	       periodo=serviceperiod.getPeriodiPrenotati().get(0);
	       periodo.setDataFine(LocalDate.now().plusYears(1));
	       serviceperiod.updatePeriodoPrenotato(periodo,periodo.getId());
	       serviceperiod.getPeriodiPrenotati().forEach(System.out::println);
	       System.out.println("DELETE");
	       serviceperiod.deletePeriodoPrenotato(periodo.getId());
	       serviceperiod.getPeriodiPrenotati().forEach(System.out::println);
	        
	        return "index";
	    }

	}


