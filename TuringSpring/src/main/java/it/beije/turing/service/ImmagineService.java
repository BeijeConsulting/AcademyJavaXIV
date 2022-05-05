package it.beije.turing.service;

import it.beije.turing.beans.Immagine;
import it.beije.turing.repository.ImmagineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ImmagineService {
    @Autowired
    private ImmagineRepository immagineRepository;

    public List<Immagine> getAllImmagine(){
        return immagineRepository.findAll();
    }

    public void addImage(Model m){
        //immagineRepository.save();
    }

}
