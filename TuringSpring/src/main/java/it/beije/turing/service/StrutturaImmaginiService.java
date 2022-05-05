package it.beije.turing.service;

import it.beije.turing.beans.StrutturaImmagini;
import it.beije.turing.repository.StrutturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrutturaImmaginiService {
    @Autowired
    private StrutturaRepository strutturaRepository;



    public List<StrutturaImmagini> getAllStrutturaImmagini(){
        return strutturaRepository.findAll();
    }


}
