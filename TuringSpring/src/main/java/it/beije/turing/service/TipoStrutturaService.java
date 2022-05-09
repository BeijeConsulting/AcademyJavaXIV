package it.beije.turing.service;

import it.beije.turing.beans.TipoStruttura;
import it.beije.turing.repository.TipoStrutturaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoStrutturaService {
    @Autowired
    private TipoStrutturaRepository tipoStrutturaRepository;


    public List<TipoStruttura> getAllTipoStruttura(){
        return tipoStrutturaRepository.findAll();
    }

    public TipoStruttura insertNewTipoStruttura( TipoStruttura tipo) {
        TipoStruttura result = tipoStrutturaRepository.save(tipo);

        return result;
    }


    public boolean deleteTipoStruttura(Integer id) {

        Optional<TipoStruttura> t = tipoStrutturaRepository.findById(id);
        tipoStrutturaRepository.delete(t.get());

        if( !tipoStrutturaRepository.existsById(id)){
            return true;
        }else {
            return false;
        }
    }


    public TipoStruttura updateTipoStruttura(Integer id, TipoStruttura nuovoTipo) {

       TipoStruttura t = getTipoStrutturaById(id);

        if( t!=null){
            nuovoTipo.setId(id);
            BeanUtils.copyProperties(nuovoTipo,t);
            tipoStrutturaRepository.save(t);
            return nuovoTipo;
        }
        return null;
    }


    public List<TipoStruttura> searchTipoStruttura(String tipo) {
        return tipoStrutturaRepository.searchByTipo(tipo);
    }


    public TipoStruttura getTipoStrutturaById(Integer id) {
        System.out.println(tipoStrutturaRepository.existsById(id));
        if(tipoStrutturaRepository.existsById(id)) {

            Optional<TipoStruttura> result = tipoStrutturaRepository.findById(id);
            System.out.println(result.get());
            return result.get();
        }else {
            return null;
        }
    }


}
