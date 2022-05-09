package it.beije.turing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.beije.turing.beans.Annuncio;
import it.beije.turing.repository.AnnuncioRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceAnnuncio 
{
	@Autowired
	private AnnuncioRepository annuncioRepository;
	
	/**
     * Restituisce una lista di tutti gli annunci
     * @return lista di annunci
     */
	public List<Annuncio> getAnnuncio()
	{
		return annuncioRepository.findAll();
	}
	
	/**
     * Inserisce un nuovo annuncio
     * @param newAnnuncio nuovo annuncio da inserire
     * @return Oggetto annuncio inserito
     */
	public Annuncio newAnnuncio(Annuncio newAnnuncio)
	{
		return annuncioRepository.save(newAnnuncio);
	}
	
	/**
     * Modifica un annuncio tramite l' ID di riferimento
     * @param newAnnuncio nuovo annuncio da inserire
     * @param annuncioId id dell' annuncio da modificare
     * @return Oggetto annuncio inserito
     */
	public Annuncio updateAnnuncio(Annuncio newAnnuncio, Integer annuncioId)
	{
		Annuncio oldAnnuncio = annuncioRepository.findById(annuncioId).get();
		
		if (newAnnuncio.getTitolo() != null && !newAnnuncio.getTitolo().equals("") && !newAnnuncio.getTitolo().equalsIgnoreCase(oldAnnuncio.getTitolo())) oldAnnuncio.setTitolo(newAnnuncio.getTitolo());
		if (newAnnuncio.getDescrizione() != null && !newAnnuncio.getDescrizione().equals("") && !newAnnuncio.getDescrizione().equalsIgnoreCase(oldAnnuncio.getDescrizione())) oldAnnuncio.setDescrizione(newAnnuncio.getDescrizione());
		if (newAnnuncio.getNumPostiLetto() > 0 &&  newAnnuncio.getNumPostiLetto() != oldAnnuncio.getNumPostiLetto()) oldAnnuncio.setNumPostiLetto(newAnnuncio.getNumPostiLetto());
		if (newAnnuncio.getPrezzo() > 0 && newAnnuncio.getPrezzo() != oldAnnuncio.getPrezzo()) oldAnnuncio.setPrezzo(newAnnuncio.getPrezzo());
		
		return annuncioRepository.save(oldAnnuncio);
	}
	
	/**
     * Cancella un annuncio tramite l' ID di riferimento
     * @param annuncioId id dell' annuncio da cancellare
     */
	public void deleteAnnuncio(Integer annuncioId)
	{
		annuncioRepository.deleteById(annuncioId);
	}
}
