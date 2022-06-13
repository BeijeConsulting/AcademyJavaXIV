package it.beije.turing.service;

import it.beije.turing.beans.Immagine;
import it.beije.turing.beans.Struttura;
import it.beije.turing.beans.StrutturaImmagini;
import it.beije.turing.repository.StrutturaImmaginiRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StrutturaImmaginiService {
    @Autowired
    private StrutturaImmaginiRepository strutturaImmaginiRepository;


    public List<StrutturaImmagini> getAllStrutturaImmagini() {
        return strutturaImmaginiRepository.findAll();
    }

    public StrutturaImmagini findStrutturaImmagini(Integer id) {
        Optional<StrutturaImmagini> c = strutturaImmaginiRepository.findById(id);
        return c.isPresent() ? c.get() : null;
    }

    public StrutturaImmagini insertStrutturaImmagini(StrutturaImmagini strutturaImmagini) {
        return strutturaImmaginiRepository.save(strutturaImmagini);
    }

    public StrutturaImmagini updateStrutturaImmagini(Integer id, StrutturaImmagini strutturaImmagini) {
        StrutturaImmagini oldStrutturaImmagini = findStrutturaImmagini(id);

        if (oldStrutturaImmagini != null) {
            BeanUtils.copyProperties(strutturaImmagini, oldStrutturaImmagini);
            strutturaImmaginiRepository.save(oldStrutturaImmagini);

            return oldStrutturaImmagini;
        }

        return null;
    }

    public void deleteStrutturaImmagini(Integer id) {
        strutturaImmaginiRepository.deleteById(id);
    }
}