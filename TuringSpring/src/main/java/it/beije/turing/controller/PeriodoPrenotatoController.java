package it.beije.turing.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.turing.beans.Annuncio;
import it.beije.turing.beans.PeriodoPrenotato;
import it.beije.turing.repository.AnnuncioRepository;
import it.beije.turing.repository.PeriodoPrenotatoRepository;
import it.beije.turing.service.FirstService;
import it.beije.turing.service.ServicePeriodoPrenotato;

@Controller
public class PeriodoPrenotatoController 
{
	@Autowired
	private ServicePeriodoPrenotato service;
	
	@Autowired
	private PeriodoPrenotatoRepository periodoPrenotatoRepository;
	
	@Autowired
	private AnnuncioRepository annuncioRepository;
	
	@RequestMapping(value = "/stampa-prenotazioni", method = RequestMethod.GET)
	public String index(Model model) 
	{
		List<PeriodoPrenotato> periodiPrenotati = service.getPeriodiPrenotati();
		
		for(PeriodoPrenotato pp : periodiPrenotati)
		{
			System.out.println(pp);
		}
		
		model.addAttribute("periodiPrenotati", periodiPrenotati);
		
		return "PeriodoPrenotatoStampa";
	}
	
	@RequestMapping(value = "/modifica-prenotazioni", method = RequestMethod.GET)
	public String modifica(Model model, @RequestParam String id) 
	{
		PeriodoPrenotato pp = periodoPrenotatoRepository.findById(Integer.getInteger(id)).get();
		
		model.addAttribute("PeriodoPrenotato", pp);
		
		return "PeriodoPrenotatoModifica";
	}
	
	@RequestMapping(value = "/modifica-prenotazioni", method = RequestMethod.POST)
	public String modificaPost(@RequestParam String id, @RequestParam LocalDateTime data_inizio, @RequestParam LocalDateTime data_fine, @RequestParam String stato_pagamento, @RequestParam String stato_accetazione) 
	{
		PeriodoPrenotato pp = new PeriodoPrenotato();

		pp.setId(Integer.getInteger(id));
		pp.setDataInizio(LocalDate.from(data_inizio));
		pp.setDataFine(LocalDate.from(data_fine));
		pp.setStatoPagamento(stato_pagamento);
		pp.setStatoAccettazione(stato_accetazione);
		
		service.updatePeriodoPrenotato(pp, Integer.getInteger(id));
		
		return "PeriodoPrenotatoStampa";
	}
	
	@RequestMapping(value = "/elimina-prenotazioni", method = RequestMethod.GET)
	public String elimina(Model model, @RequestParam String id) 
	{
		service.deletePeriodoPrenotato(Integer.getInteger(id));
		
		return "PeriodoPrenotatoStampa";
	}
	
	@RequestMapping(value = "/inserisci-prenotazione", method = RequestMethod.GET)
	public String inserisci(Model model) 
	{
		return "PeriodoPrenotatoInserisci";
	}
	
	@RequestMapping(value = "/inserisci-prenotazione", method = RequestMethod.POST)
	public String inserisciPost(@RequestParam String annuncio_id, @RequestParam String utente_id, @RequestParam LocalDateTime data_inizio, @RequestParam LocalDateTime data_fine, @RequestParam String stato_pagamento, @RequestParam String stato_accettazione) 
	{
		PeriodoPrenotato pp = new PeriodoPrenotato();

		Annuncio annuncio =  annuncioRepository.findById(Integer.getInteger(annuncio_id)).get();
		
		pp.setAnnuncio(annuncio);
		pp.setDataInizio(LocalDate.from(data_inizio));
		pp.setDataFine(LocalDate.from(data_fine));
		pp.setStatoPagamento(stato_pagamento);
		pp.setStatoAccettazione(stato_accettazione);
		
		service.newPeriodoPrenotato(pp);
		
		return "PeriodoPrenotatoStampa";
	}
}
