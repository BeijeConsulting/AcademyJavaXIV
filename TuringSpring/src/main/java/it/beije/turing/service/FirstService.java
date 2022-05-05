package it.beije.turing.service;

import java.util.Objects;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import it.beije.turing.beans.FotoAnnuncio;
import it.beije.turing.beans.Annuncio;
import it.beije.turing.beans.Regola;
import it.beije.turing.beans.PeriodoPrenotato;

import it.beije.turing.repository.AnnuncioRepository;
import it.beije.turing.repository.FotoAnnuncioRepository;
import it.beije.turing.repository.RegolaRepository;
import it.beije.turing.repository.PeriodoPrenotatoRepository;

@Service
public class FirstService
{
	@Autowired
	private AnnuncioRepository ar;
	
	@Autowired
	private FotoAnnuncioRepository fotoAnnuncioRepository;
	
	@Autowired
	private PeriodoPrenotatoRepository periodoPrenotatoRepository;
	
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
        
        if(newFotoAnnuncio.getAnnuncio() != null) oldFotoAnnuncio.setAnnuncio(newFotoAnnuncio.getAnnuncio());

        if(newFotoAnnuncio.getImmagineId() != null) oldFotoAnnuncio.setImmagineId(newFotoAnnuncio.getImmagineId());

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
	 
	 public void deleteRegola(Regola regola)
	 {
		 regolaRepository.deleteById(regola.getId());
	 }
	 
	 public List<PeriodoPrenotato>  getPeriodiPrenotati()
	 {
		 return (List<PeriodoPrenotato>) periodoPrenotatoRepository.findAll();
	 }
	 
	 public PeriodoPrenotato newPeriodoPrenotato(PeriodoPrenotato periodoPrenotato, Integer periodoPrenotatoId)
	 {
		PeriodoPrenotato periodoPrenotatoDB = periodoPrenotatoRepository.findById(periodoPrenotatoId).get();
		
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
	
	public PeriodoPrenotato updatePeriodoPrenotato(PeriodoPrenotato periodoPrenotato)
	{
		return periodoPrenotatoRepository.save(periodoPrenotato);
	}
	
	public void deletePeriodoPrenotato(Integer id)
	{
		periodoPrenotatoRepository.deleteById(id);
	}
}