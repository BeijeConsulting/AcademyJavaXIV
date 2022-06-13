package it.beije.turing.service;
import it.beije.turing.beans.Immagine;
import it.beije.turing.repository.ImmagineRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ImmagineService {
    @Autowired
    private ImmagineRepository immagineRepository;

    public List<Immagine> getAllImmagine(){
        return immagineRepository.findAll();
    }

    public Immagine findContatto(Integer id) {
        Optional<Immagine> c = immagineRepository.findById(id);
        return c.isPresent() ? c.get() : null;
    }

    public Immagine insertImmagine(Immagine immagine) {
        return immagineRepository.save(immagine);
    }

    public Immagine updateImmagine(Integer id, Immagine immagine) {
        Immagine oldImmagine = findContatto(id);

        if (oldImmagine != null) {
            BeanUtils.copyProperties(immagine, oldImmagine);
            immagineRepository.save(oldImmagine);

            return oldImmagine;
        }

        return null;
    }

    public void deleteImmagine(Integer id) {
        immagineRepository.deleteById(id);
    }
}
