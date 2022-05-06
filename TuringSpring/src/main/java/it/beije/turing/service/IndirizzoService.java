package it.beije.turing.service;

import it.beije.turing.beans.Indirizzo;
import it.beije.turing.beans.TipoStruttura;
import it.beije.turing.repository.IndirizzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndirizzoService {

    @Autowired
    private IndirizzoRepository indirizzoRepository;

    /**
     * Restituisce una lista di tutti gli indirizzi
     * @return lista di indirizzi
     */
    public List<Indirizzo> getAllIndirizzi(){
        return indirizzoRepository.findAll();
    }

    /**
     * Inserisce un nuovo indirzzo
     * @param cap
     * @param citta
     * @param coordinate
     * @param numeroCivico
     * @param stato
     * @param provincia
     * @param via
     * @return true se è stato inserito, false se non è stato inserito
     *
     */
    public Boolean insertNewIndirizzo(String cap, String citta, String coordinate, String numeroCivico, String stato, String via, String provincia) {
        Indirizzo indirizzo= new Indirizzo();
        indirizzo.setCap(cap);
        indirizzo.setCitta(citta);
        indirizzo.setCoordinate(coordinate);
        indirizzo.setNumeroCivico(numeroCivico);
        indirizzo.setStato(stato);
        indirizzo.setVia(via);
        indirizzo.setProvincia(provincia);

        Indirizzo result = indirizzoRepository.save(indirizzo);

        if(result.getId()==null){
            return false;
        }else {
            return true;
        }
    }

    /**
     * Cancella un indirizzo tramite l' ID di riferimento
     * @param id id dell'indirizzo da cancellare
     * @return true se è stato cancellato, false se non è stato cancellato
     *
     */
    public boolean deleteIndirizzo(Integer id) {

        Optional<Indirizzo> i = indirizzoRepository.findById(id);
        indirizzoRepository.delete(i.get());

        if( !indirizzoRepository.existsById(id)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Modifica indirizzo
     * @param id id dell'indirizzo da modificare
     * @param nuovoCap
     * @param nuovaCitta
     * @param nuoveCoordinate
     * @param nuovoNumeroCivico
     * @param nuovoStato
     * @param nuovaVia
     * @param nuovaProvincia
     * @return true se la modifica è avvenuta con successo false altrimenti
     */
    public boolean updateIndirizzo(Integer id, String nuovoCap, String nuovaCitta, String nuoveCoordinate, String nuovoNumeroCivico, String nuovoStato, String nuovaVia, String nuovaProvincia) {

        Indirizzo result = null;
        Optional<Indirizzo> t = indirizzoRepository.findById(id);

        if( indirizzoRepository.existsById(id)){
            result=t.get();
            result.setProvincia(nuovaProvincia);
            result.setVia(nuovaVia);
            result.setStato(nuovoStato);
            result.setCoordinate(nuoveCoordinate);
            result.setNumeroCivico(nuovoNumeroCivico);
            result.setCap(nuovoCap);
            result.setCitta(nuovaCitta);
            indirizzoRepository.save(result);
        }
        if((indirizzoRepository.findById(id).get().equals(result))){
            return true;
        }else{
            return false;
        }
    }

    public Indirizzo findIndirizzoByID(Integer idIndirizzo) {

        if(indirizzoRepository.existsById(idIndirizzo)) {
            Optional<Indirizzo> result = indirizzoRepository.findById(idIndirizzo);
            Indirizzo t = result.get();
            return t;
        }else {
            return null;
        }
    }
}
