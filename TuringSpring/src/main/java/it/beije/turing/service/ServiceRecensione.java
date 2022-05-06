package it.beije.turing.service;

import it.beije.turing.beans.Recensione;
import it.beije.turing.beans.Struttura;
import it.beije.turing.repository.RecensioneRepository;
import it.beije.turing.repository.StrutturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRecensione {
    @Autowired
    private RecensioneRepository recensioneRepository;

    public List<Recensione> getAllRecensione(){
        return recensioneRepository.findAll();
    }

    public List<Recensione> findRecensionebyRange(Integer min, Integer max){
        return recensioneRepository.searchByPunteggioRange(min, max);
    }

    public Recensione creaRecensione(String testo,
                                     String data,
                                     Integer punteggio,
                                     Integer reviewerId,
                                     Integer prenotazioneId){
        Recensione recensione = new Recensione();
        recensione.setTesto(testo);
        recensione.setData(data);
        recensione.setPunteggio(punteggio);
        recensione.setReviewerId(reviewerId);
        recensione.setPrenotazioneId(prenotazioneId);
        recensioneRepository.saveAndFlush(recensione);
        return recensione;
    }

    public void rimuoviRecensione (Integer recId){
        recensioneRepository.deleteById(recId);
    }

    public Recensione updateRecensione (Integer id,
                                        String testo,
                                        String data,
                                        Integer punteggio,
                                        Integer reviewerId,
                                        Integer prenotazioneId){
        Recensione recensione = recensioneRepository.findById(id).get();
        if (recensione==null){
            return recensione;
        }
        if (testo!=null) recensione.setTesto(testo);
        if (data!=null) recensione.setData(data);
        if (punteggio!=null) recensione.setPunteggio(punteggio);
        if (reviewerId!=null) recensione.setReviewerId(reviewerId);
        if (prenotazioneId!=null) recensione.setPrenotazioneId(prenotazioneId);
        recensioneRepository.save(recensione);
        return recensione;
    }
}
