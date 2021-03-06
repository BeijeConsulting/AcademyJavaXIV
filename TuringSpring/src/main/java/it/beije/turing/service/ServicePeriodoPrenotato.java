package it.beije.turing.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.turing.beans.PeriodoPrenotato;
import it.beije.turing.repository.PeriodoPrenotatoRepository;

@Service
public class ServicePeriodoPrenotato 
{
	@Autowired
	private PeriodoPrenotatoRepository periodoPrenotatoRepository;
	
	/**
     * Restituisce una lista di tutti i periodo prenotato
     * @return lista di periodi prenotati
     */
	public List<PeriodoPrenotato>  getPeriodiPrenotati()
	{
		return (List<PeriodoPrenotato>) periodoPrenotatoRepository.findAll();
	}
	
	/**
     * Restituisce un periodo prenotato tramite l' ID di riferimento
     * @param periodoPrenotatoId id del periodo prenotato da trovare
     * @return periodo prenotato trovato
     */
	public PeriodoPrenotato  findPeriodoPrenotato(Integer periodoPrenotatoId)
	{
		return periodoPrenotatoRepository.findById(periodoPrenotatoId).get();
	}
	 
	/**
     * Modifica un periodo prenotato tramite l' ID di riferimento
     * @param periodoPrenotato nuovo periodo prenotato da inserire
     * @param periodoPrenotatoId id del periodo prenotato da modificare
     * @return Oggetto periodo prenotato inserito
     */
	public PeriodoPrenotato updatePeriodoPrenotato(PeriodoPrenotato periodoPrenotato, Integer periodoPrenotatoId)
	{
		PeriodoPrenotato periodoPrenotatoDB = findPeriodoPrenotato(periodoPrenotatoId);
		
		if (Objects.nonNull(periodoPrenotato.getDataInizio()) && !"".equalsIgnoreCase(periodoPrenotato.getDataInizio().toString()))
		{
			periodoPrenotatoDB.setDataInizio(periodoPrenotato.getDataInizio());
		}
		
		if (Objects.nonNull(periodoPrenotato.getDataFine()) && !"".equalsIgnoreCase(periodoPrenotato.getDataFine().toString()))
		{
			periodoPrenotatoDB.setDataFine(periodoPrenotato.getDataFine());
		}
		
		if (Objects.nonNull(periodoPrenotato.getStatoPagamento()) && !"".equalsIgnoreCase(periodoPrenotato.getStatoPagamento()))
		{
			periodoPrenotatoDB.setStatoPagamento(periodoPrenotato.getStatoPagamento());
		}
		
		if (Objects.nonNull(periodoPrenotato.getStatoAccettazione()) && !"".equalsIgnoreCase(periodoPrenotato.getStatoAccettazione()))
		{
			periodoPrenotatoDB.setStatoAccettazione(periodoPrenotato.getStatoAccettazione());
		}

		return periodoPrenotatoRepository.save(periodoPrenotatoDB);
	}
	
	/**
     * Inserisce un nuovo periodo prenotato
     * @param periodoPrenotato nuovo periodo prenotato da inserire
     * @return Oggetto periodo prenotato inserito
     */
	public PeriodoPrenotato newPeriodoPrenotato(PeriodoPrenotato periodoPrenotato)
	{
		if(Objects.nonNull(periodoPrenotato.getDataInizio()) && Objects.nonNull(periodoPrenotato.getDataFine()) && Objects.nonNull(periodoPrenotato.getStatoPagamento()) && Objects.nonNull(periodoPrenotato.getStatoAccettazione()) ) {			
			return periodoPrenotatoRepository.save(periodoPrenotato);
		} else {
			return null;
		}
	}
	
	 /**
     * Cancella un periodo prenotato tramite l' ID di riferimento
     * @param id id dell periodo prenotato da cancellare
     */
	public void deletePeriodoPrenotato(Integer id)
	{
		periodoPrenotatoRepository.deleteById(id);
	}
}
