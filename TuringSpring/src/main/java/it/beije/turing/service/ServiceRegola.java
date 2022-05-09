package it.beije.turing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.beije.turing.beans.Regola;
import it.beije.turing.repository.RegolaRepository;

public class ServiceRegola 
{
	@Autowired
	private RegolaRepository regolaRepository;
	
	/**
     * Restituisce una lista di regole
     * @return lista di regole
     */
    public List<Regola> getRegola()
	{
    	return regolaRepository.findAll();
	}
	
    /**
     * Inserisce una nuova regola
     * @param regola nuova regola da inserire
     * @return Oggetto foto annuncio inserito
     */
	public Regola newRegola(Regola regola)
	{
		return regolaRepository.save(regola);
	}
		
	/**
     * Modifica una regola tramite l' ID di riferimento
     * @param regola nuova regola da inserire
     * @return Oggetto foto annuncio inserito
     */
	public Regola updateRegola(Regola regola)
	{
		Regola tmp = regolaRepository.findById(regola.getId()).get();
			 
		if (regola.getTitolo() != null && !"".equals(regola.getTitolo()))
		{
			tmp.setTitolo(regola.getTitolo());
		}
			 
		if (regola.getDescrizione() != null && !"".equals(regola.getDescrizione()))
		{
			tmp.setDescrizione(regola.getDescrizione());
		} 
		
		return regolaRepository.save(tmp);
	}
	
	/**
     * Cancella una regola tramite l' ID di riferimento
     * @param regola regola da cancellare
     */
	public void deleteRegola(Regola regola)
	{
		regolaRepository.deleteById(regola.getId());
	}
}
