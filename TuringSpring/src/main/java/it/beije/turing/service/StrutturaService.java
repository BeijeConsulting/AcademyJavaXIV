package it.beije.turing.service;

import it.beije.turing.beans.Indirizzo;
import it.beije.turing.beans.Struttura;
import it.beije.turing.beans.TipoStruttura;
import it.beije.turing.beans.Utente;
import it.beije.turing.repository.StrutturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StrutturaService {
    @Autowired
    private StrutturaRepository strutturaRepository;

    @Autowired
    private TipoStrutturaService tipoStruttura;
    public List<Struttura> getAllStruttura(){
        return strutturaRepository.findAll();
    }


    public void insertNewTipoStruttura(String descrizione, Integer idTipoStrutture, Integer idIndirizzo, Integer idUtente) {
        TipoStruttura tipoStrutturaResult=null;
        tipoStrutturaResult=tipoStruttura.getTipoStrutturaById(idTipoStrutture);

        if(tipoStrutturaResult!=null){

            Struttura struttura= new Struttura();
            struttura.setDescrizione(descrizione);

            //struttura.setTipologiaStrutturaId(tipoStrutturaResult);

            //struttura.setIndirizzo(indirizzo);
            //struttura.setUtente(utente);

            strutturaRepository.save(struttura);
            System.out.println(struttura);
        }
    }

    public boolean deleteStruttura(Integer idStruttura) {
        System.out.println(idStruttura);
        Optional<Struttura> t = strutturaRepository.findById(idStruttura);
        strutturaRepository.delete(t.get());

        if( !strutturaRepository.existsById(idStruttura)){
            return true;
        }else {
            return false;
        }
    }
}
