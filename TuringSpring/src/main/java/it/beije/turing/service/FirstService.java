package it.beije.turing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.turing.beans.Annuncio;
import it.beije.turing.repository.AnnuncioRepository;


//Lettura scrittura modifica cancella

@Service
public class FirstService
{
	@Autowired
	private AnnuncioRepository ar;
	
	public List<Annuncio> getAnnuncio()
	{
		return ar.findAll();
	}
	
	public Annuncio newAnnuncio(Annuncio newAnnuncio)
	{
		return ar.save(newAnnuncio);
	}
	
	public Annuncio updateAnnuncio(Annuncio newAnnuncio, Integer annuncioId)
	{
		Annuncio oldAnnuncio = ar.findById(annuncioId).get();
		
		if (newAnnuncio.getTitolo() != null && !newAnnuncio.getTitolo().equals("") && !newAnnuncio.getTitolo().equalsIgnoreCase(oldAnnuncio.getTitolo())) oldAnnuncio.setTitolo(newAnnuncio.getTitolo());
		if (newAnnuncio.getDescrizione() != null && !newAnnuncio.getDescrizione().equals("") && !newAnnuncio.getDescrizione().equalsIgnoreCase(oldAnnuncio.getDescrizione())) oldAnnuncio.setDescrizione(newAnnuncio.getDescrizione());
		if (newAnnuncio.getNumPostiLetto() > 0 &&  newAnnuncio.getNumPostiLetto() != oldAnnuncio.getNumPostiLetto()) oldAnnuncio.setNumPostiLetto(newAnnuncio.getNumPostiLetto());
		if (newAnnuncio.getPrezzo() > 0 && newAnnuncio.getPrezzo() != oldAnnuncio.getPrezzo()) oldAnnuncio.setPrezzo(newAnnuncio.getPrezzo());
		
		return ar.save(oldAnnuncio);
	}
	
	public void deleteAnnuncio(Integer annuncioId)
	{
		ar.deleteById(annuncioId);
	}
}