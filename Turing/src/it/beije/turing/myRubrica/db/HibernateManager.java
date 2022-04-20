package it.beije.turing.myRubrica.db;

import it.beije.turing.myRubrica.interfaces.OpRubrica;
import it.beije.turing.myRubrica.interfaces.Order;
import it.beije.turing.rubrica.Contatto;

import java.util.List;

/**
 * @author Giuseppe Raddato
 * Data: 19 apr 2022
 */
public class HibernateManager implements OpRubrica {
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
    public List<Contatto> contattiDuplicati() {
        return null;
    }

    @Override
    public void unisciContatti() {

    }

    @Override
    public List<Contatto> importFromCVS(String path) {
        return null;
    }

    @Override
    public List<Contatto> importFromXML(String path) {
        return null;
    }

    @Override
    public void exportFromCVS(String path, List<Contatto> contatti) {

    }

    @Override
    public void exportFromXML(String path, List<Contatto> contatti) {

    }
}
