package it.beije.turing.service;

import it.beije.turing.beans.Indirizzo;
import it.beije.turing.beans.TipoStruttura;
import it.beije.turing.repository.IndirizzoRepository;
import org.springframework.beans.BeanUtils;
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
     * @param indirizzo
     * @return true se è stato inserito, false se non è stato inserito
     *
     */
    public Indirizzo insertNewIndirizzo(Indirizzo indirizzo) {

        Indirizzo result = indirizzoRepository.save(indirizzo);

        if(result.getId()==null){
            return indirizzo;
        }else {
            return null;
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

        if(!indirizzoRepository.existsById(id)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Modifica indirizzo
     * @param id id dell'indirizzo da modificare
     * @param indirizzo
     * @return true se la modifica è avvenuta con successo false altrimenti
     */
    public Indirizzo updateIndirizzo(Integer id, Indirizzo indirizzo) {
            Optional<Indirizzo> oldIndirizzo = indirizzoRepository.findById(id);
            if(oldIndirizzo.isPresent()) {
                Indirizzo old = oldIndirizzo.get();

                if (indirizzoRepository.existsById(id)) {
                    BeanUtils.copyProperties(indirizzo, old);
                    indirizzoRepository.save(old);

                    return old;
                }
            }

            return null;
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
