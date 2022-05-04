package it.beije.turing.myrubrica;

import it.beije.turing.example.Contatto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRubrica implements OpRubrica{
    @Override
    public List<Contatto> showContact(Order order) {
        return null;
    }

    @Override
    public List<Contatto> search(String s) {
        return null;
    }

    @Override
    public boolean insert(Contatto c) {
        return false;
    }

    @Override
    public boolean modificaContatto(Contatto c) {
        return false;
    }

    @Override
    public boolean deleteContatto(Contatto c) {
        return false;
    }

    @Override
    public List<List<Contatto>> contattiDuplicati() {
        return null;
    }

    @Override
    public void unisciContatti(List<List<Contatto>> l) {

    }

    @Override
    public List<Contatto> importFromCVS(String path, String separator) {
        return null;
    }

    @Override
    public List<Contatto> importFromXML(String path) {
        return null;
    }

    @Override
    public void exportFromCVS(String path, List<Contatto> contats, String separator) {

    }

    @Override
    public void exportFromXML(String path, List<Contatto> contatti) {

    }
}
