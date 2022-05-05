package it.beije.turing.service;

import it.beije.turing.beans.TipoStruttura;
import it.beije.turing.repository.TipoStrutturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoStrutturaService {
    @Autowired
    private TipoStrutturaRepository tipoStrutturaRepository;

    /**
     * Restituisce una lista di tutti i tipo di struttura
     * @return lista di tipi struttura
     */
    public List<TipoStruttura> getAllTipoStruttura(){
        return tipoStrutturaRepository.findAll();
    }
    /**
     * Inserisce un nuovo tipo struttura con la sua
     * @param tipo descrizione del tipo della struttura
     * @return true se è stato inserito false se non è stato inserito
     *
     */
    public Boolean insertNewTipoStruttura(String tipo) {
        TipoStruttura tipoStruttura= new TipoStruttura();
        tipoStruttura.setTipo(tipo);

        TipoStruttura result = tipoStrutturaRepository.save(tipoStruttura);

        if(result.getId()==null){
            return false;
        }else {
            return true;
        }
    }

    /**
     * Cancella un tipo struttura tramite l' ID di riferimento
     * @param id id della struttura da cancellare
     * @return true se è stato cancellato false se non è stato cancellato
     *
     */
    public boolean deleteTipoStruttura(Integer id) {

        Optional<TipoStruttura> t = tipoStrutturaRepository.findById(id);
        tipoStrutturaRepository.delete(t.get());

        if( !tipoStrutturaRepository.existsById(id)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Modifica tipo di struttura
     * @param id id del tipo di struttura da modificare
     * @param nuovoTipo nuovo valore
     * @return true se la modifica è avvenuta con successo false altrimenti
     */
    public boolean updateTipoStruttura(Integer id,String nuovoTipo) {

        Optional<TipoStruttura> t = tipoStrutturaRepository.findById(id);

        if( tipoStrutturaRepository.existsById(id)){
            TipoStruttura result=t.get();
            result.setTipo(nuovoTipo);
            tipoStrutturaRepository.save(result);
        }
        if((tipoStrutturaRepository.findById(id).get().getTipo().equals(nuovoTipo))){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Cerca una determinato tipo struttura
     * @param tipo di struttura da ricercare
     * @return lista di tutti gli elementi che hanno quella nomenclatura
     */
    public List<TipoStruttura> searchTipoStruttura(String tipo) {
        return tipoStrutturaRepository.searchByTipo(tipo);
    }
}
