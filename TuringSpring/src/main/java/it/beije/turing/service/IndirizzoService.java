package it.beije.turing.service;

import it.beije.turing.beans.Indirizzo;
import it.beije.turing.beans.TipoStruttura;
import it.beije.turing.repository.IndirizzoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * @param indirizzo descrizione dell'indirizzo
     * @return true se è stato inserito, false se non è stato inserito
     *
     */
    public Boolean insertNewIndirizzo(String indirizzo) {
        Indirizzo indirizzo= new Indirizzo();
        indirizzo.setCap();
        indirizzo.setCitta();
        indirizzo.

        Indirizzo result = indirizzoRepository.save(indirizzo);

        if(result.getId()==null){
            return false;
        }else {
            return true;
        }
    }
}
