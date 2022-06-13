package it.beije.turing.service;


import it.beije.turing.beans.Struttura;
import it.beije.turing.repository.StrutturaRepository;
import org.springframework.beans.BeanUtils;
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

    public List<Struttura> getAllStruttura() {
        return strutturaRepository.findAll();
    }


    public Struttura insertNewTipoStruttura(Struttura struttura) {
        return  strutturaRepository.save(struttura);

    }

    public boolean deleteStruttura(Integer idStruttura) {
        strutturaRepository.deleteById(idStruttura);

        if (!strutturaRepository.existsById(idStruttura)) {
            return true;
        } else {
            return false;
        }
    }

    public Struttura findStrutturaById(Integer idStruttura) {
        if (strutturaRepository.existsById(idStruttura)) {
            return strutturaRepository.findById(idStruttura).get();
        } else {
            return null;
        }
    }

    public Struttura updateStructure(Integer id_stru, Struttura struttura) {

           if(strutturaRepository.existsById(id_stru)){
              Struttura result= strutturaRepository.findById(id_stru).get();
              struttura.setId(id_stru);
              BeanUtils.copyProperties(struttura,result);
              return strutturaRepository.save(result);
           }
           return null;
    }
}
