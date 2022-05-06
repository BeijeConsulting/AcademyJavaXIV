package it.beije.turing.service;

import it.beije.turing.beans.Immagine;
import it.beije.turing.beans.Struttura;
import it.beije.turing.beans.StrutturaImmagini;
import it.beije.turing.repository.StrutturaImmaginiRepository;
import it.beije.turing.repository.StrutturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StrutturaImmaginiService {
    @Autowired
    private StrutturaImmaginiRepository strutturaImmaginiRepository;



    public List<StrutturaImmagini> getAllStrutturaImmagini(){
        return strutturaImmaginiRepository.findAll();
    }

    public void addStructureImage(Struttura strutturaId, Immagine immagineId ){
        StrutturaImmagini strutImm= new StrutturaImmagini();
        strutImm.setStruttura(strutturaId);
        //strutImm.setImmagine( immagineId);
        strutturaImmaginiRepository.save(strutImm);
    }

    public void delateImageStructure(int structureImageId) {
        Optional<StrutturaImmagini> i= strutturaImmaginiRepository.findById(structureImageId);
        strutturaImmaginiRepository.delete(i.get());
    }
}
