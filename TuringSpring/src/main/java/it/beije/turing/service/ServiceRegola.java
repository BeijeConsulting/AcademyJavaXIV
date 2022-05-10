package it.beije.turing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.turing.beans.ListaRegole;
import it.beije.turing.beans.Regola;
import it.beije.turing.repository.RegolaRepository;
@Service
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
	 * @param id 
     * @return Oggetto foto annuncio inserito
     */
	public Regola updateRegola(Regola regola, Integer id)
	{
		Regola tmp = regolaRepository.findById(id).get();
			 
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
     * @param id regola da cancellare
     */
	public void deleteRegola(Integer id)
	{
		regolaRepository.deleteById(id);
	}

	public Regola getRegola(Integer id) {
			Optional<Regola> opt = regolaRepository.findById(id);
			return opt.isPresent() ? opt.get() : null;
	}
}
