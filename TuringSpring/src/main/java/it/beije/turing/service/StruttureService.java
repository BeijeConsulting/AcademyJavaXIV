package it.beije.turing.service;

import it.beije.turing.beans.Struttura;
import it.beije.turing.repository.StrutturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StruttureService {
    @Autowired
    private StrutturaRepository strutturaRepository;



    public List<Struttura> getAll(){
        return strutturaRepository.findAll();
    }


}
