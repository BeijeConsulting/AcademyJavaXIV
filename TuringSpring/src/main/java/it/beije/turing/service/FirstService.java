package it.beije.turing.service;

import java.util.List;
import it.beije.turing.beans.FotoAnnuncio;
import it.beije.turing.repository.AnnuncioRepository;
import it.beije.turing.repository.FotoAnnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.turing.beans.Annuncio;
import it.beije.turing.beans.Regola;
import it.beije.turing.repository.RegolaRepository;

@Service
public class FirstService
{
	@Autowired
	private AnnuncioRepository ar;
	
	@Autowired
	private FotoAnnuncioRepository fotoAnnuncioRepository;
	
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

    public List<FotoAnnuncio> getFotoAnnuncio()
    {
        return fotoAnnuncioRepository.findAll();
    }
    
    public FotoAnnuncio newFotoAnnuncio(FotoAnnuncio fotoAnnuncio)
    {
        return fotoAnnuncioRepository.save(fotoAnnuncio);
    }

    public  FotoAnnuncio updateFotoAnnuncio(FotoAnnuncio newFotoAnnuncio, Integer fotoAnnuncioId)
    {
        FotoAnnuncio oldFotoAnnuncio = fotoAnnuncioRepository.findById(fotoAnnuncioId).get();
        
        if(newFotoAnnuncio.getAnnuncio() != null  ) oldFotoAnnuncio.setAnnuncio(newFotoAnnuncio.getAnnuncio());

        if(newFotoAnnuncio.getImmagineId()!= null) oldFotoAnnuncio.setImmagineId(newFotoAnnuncio.getImmagineId());

        return fotoAnnuncioRepository.save(oldFotoAnnuncio);
    }

    public void deleteFotoAnnuncio(Integer fotoAnnuncioId)
    {
        fotoAnnuncioRepository.deleteById(fotoAnnuncioId);
    }
    
	@Autowired
	private RegolaRepository regolaRepository;

	 public List<Regola> getRegola()
	 {
		return regolaRepository.findAll();
	 }
	
	 public Regola newRegola(Regola regola)
	 {
		 return regolaRepository.save(regola);
	 }
	 
	 public Regola updateRegola(Regola regola)
	 {
		 Regola tmp = regolaRepository.findById(regola.getId()).get();
		 
		 if (regola.getTitolo()!=null && !"".equals(regola.getTitolo()))
		 {
			 tmp.setTitolo(regola.getTitolo());
		 }
		 
		 if (regola.getDescrizione()!=null && !"".equals(regola.getDescrizione()))
		 {
			 tmp.setDescrizione(regola.getDescrizione());
		 }
		 
		 return regolaRepository.save(tmp);
	 }
	 
	 public void deleteRegola(Regola regola)
	 {
		 regolaRepository.deleteById(regola.getId());
	 }
}