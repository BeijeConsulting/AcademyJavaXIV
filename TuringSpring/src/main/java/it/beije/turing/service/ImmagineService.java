package it.beije.turing.service;

import it.beije.turing.beans.Immagine;
import it.beije.turing.repository.ImmagineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImmagineService {
    @Autowired
    private ImmagineRepository immagineRepository;

    public List<Immagine> getAllImmagine(){
        return immagineRepository.findAll();
    }


}
