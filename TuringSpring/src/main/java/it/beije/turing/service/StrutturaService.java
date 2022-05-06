package it.beije.turing.service;


import it.beije.turing.beans.Indirizzo;
import it.beije.turing.beans.Struttura;
import it.beije.turing.beans.TipoStruttura;
import it.beije.turing.repository.StrutturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrutturaService {
    @Autowired
    private StrutturaRepository strutturaRepository;

    @Autowired
    private TipoStrutturaService tipoStrutturaService;

    @Autowired
    private IndirizzoService indirizzoService;
    public List<Struttura> getAllStruttura(){
        return strutturaRepository.findAll();
    }


    public void insertNewTipoStruttura(String descrizione, Integer idTipoStrutture, Integer idIndirizzo, Integer idUtente) {
        TipoStruttura tipoStrutturaResult= tipoStrutturaService.getTipoStrutturaById(idTipoStrutture);
        Indirizzo indirizzo = indirizzoService.findIndirizzoByID(idIndirizzo);

        if(tipoStrutturaResult!=null && indirizzo!=null){

            Struttura struttura= new Struttura();
            struttura.setDescrizione(descrizione);

            struttura.setTipologiaStrutturaId(tipoStrutturaResult);

            struttura.setIndirizzo(indirizzo);
            //struttura.setUtente(utente);

            strutturaRepository.save(struttura);
            System.out.println(struttura);
        }
    }

    public boolean deleteStruttura(Integer idStruttura) {
        strutturaRepository.deleteById(idStruttura);

        if( !strutturaRepository.existsById(idStruttura)){
            return true;
        }else {
            return false;
        }
    }

    public Struttura findStrutturaById(Integer idStruttura) {
        if(  strutturaRepository.existsById(idStruttura)  ){
            return strutturaRepository.findById(idStruttura).get();
        }else {
            return null;
        }
    }
}
