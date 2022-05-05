package it.beije.turing.service;

import java.util.List;
import java.util.Objects;

import it.beije.turing.JpaEntityManager;
import it.beije.turing.beans.FotoAnnuncio;
import it.beije.turing.repository.AnnuncioRepository;
import it.beije.turing.repository.FotoAnnuncioRepository;
import it.beije.turing.repository.StrutturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;


@Service
public class FirstService {

    @Autowired
    private FotoAnnuncioRepository fotoAnnuncioRepository;
    public List<FotoAnnuncio> getFotoAnnuncio(){
        return fotoAnnuncioRepository.findAll();
    }
    public FotoAnnuncio newFotoAnnuncio(FotoAnnuncio fotoAnnuncio){
        return fotoAnnuncioRepository.save(fotoAnnuncio);
    }

    public  FotoAnnuncio updateFotoAnnuncio(FotoAnnuncio newFotoAnnuncio, Integer fotoAnnuncioId){
        FotoAnnuncio oldFotoAnnuncio = fotoAnnuncioRepository.findById(fotoAnnuncioId).get();
        if(newFotoAnnuncio.getAnnuncio() != null  ) oldFotoAnnuncio.setAnnuncio(newFotoAnnuncio.getAnnuncio());

        if(newFotoAnnuncio.getImmagineId()!= null) oldFotoAnnuncio.setImmagineId(newFotoAnnuncio.getImmagineId());

        return fotoAnnuncioRepository.save(oldFotoAnnuncio);
    }

    public void deleteFotoAnnuncio(Integer fotoAnnuncioId){
        fotoAnnuncioRepository.deleteById(fotoAnnuncioId);
    }
}
