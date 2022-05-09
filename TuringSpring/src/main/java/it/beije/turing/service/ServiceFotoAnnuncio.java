package it.beije.turing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.turing.beans.FotoAnnuncio;
import it.beije.turing.repository.FotoAnnuncioRepository;


@Service
public class ServiceFotoAnnuncio 
{
	@Autowired
	private FotoAnnuncioRepository fotoAnnuncioRepository;
	
	/**
     * Restituisce una lista di tutte le foto collegate agli annunci
     * @return lista di foto annuncio
     */
	public List<FotoAnnuncio> getFotoAnnuncio()
    {
        return fotoAnnuncioRepository.findAll();
    }
    
	/**
     * Inserisce un nuovo oggetto foto annuncio
     * @param fotoAnnuncio nuovo foto annuncio da inserire
     * @return Oggetto foto annuncio inserito
     */
    public FotoAnnuncio newFotoAnnuncio(FotoAnnuncio fotoAnnuncio)
    {
        return fotoAnnuncioRepository.save(fotoAnnuncio);
    }

    /**
     * Modifica un foto annuncio tramite l' ID di riferimento
     * @param newFotoAnnuncio nuovo foto annuncio da inserire
     * @param fotoAnnuncioId id del foto annuncio da modificare
     * @return Oggetto foto annuncio inserito
     */
    public  FotoAnnuncio updateFotoAnnuncio(FotoAnnuncio newFotoAnnuncio, Integer fotoAnnuncioId)
    {
        FotoAnnuncio oldFotoAnnuncio = fotoAnnuncioRepository.findById(fotoAnnuncioId).get();
        
        if(newFotoAnnuncio.getAnnuncio() != null) oldFotoAnnuncio.setAnnuncio(newFotoAnnuncio.getAnnuncio());

        if(newFotoAnnuncio.getImmagineId() != null) oldFotoAnnuncio.setImmagineId(newFotoAnnuncio.getImmagineId());

        return fotoAnnuncioRepository.save(oldFotoAnnuncio);
    }

    /**
     * Cancella un foto annuncio tramite l' ID di riferimento
     * @param annuncioId id dell' oggetto foto annuncio da cancellare
     */
    public void deleteFotoAnnuncio(Integer fotoAnnuncioId)
    {
        fotoAnnuncioRepository.deleteById(fotoAnnuncioId);
    }
}
