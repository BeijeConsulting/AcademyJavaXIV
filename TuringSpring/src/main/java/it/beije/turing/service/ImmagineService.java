package it.beije.turing.service;

import it.beije.turing.beans.Immagine;
import it.beije.turing.beans.TipoStruttura;
import it.beije.turing.repository.ImmagineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class ImmagineService {
    @Autowired
    private ImmagineRepository immagineRepository;

    public List<Immagine> getAllImmagine(){
        return immagineRepository.findAll();
    }

    public void addImage(String url){
        Immagine immagine = new Immagine();
        immagine.setUrlImage(url);
        immagineRepository.save(immagine);
    }

    public void delateImmagine(int imageId) {
        Optional<Immagine> i= immagineRepository.findById(imageId);
        immagineRepository.delete(i.get());
    }

    public boolean updateTipoStruttura(int id,String urlImage) {

        Optional<Immagine> t = immagineRepository.findById(id);

        if( immagineRepository.existsById(id)){
            Immagine result=t.get();
            result.setUrlImage(urlImage);
            immagineRepository.save(result);
        }
        if((immagineRepository.findById(id).get().getUrlImage().equals(urlImage))){
            return true;
        }else{
            return false;
        }
    }

}
