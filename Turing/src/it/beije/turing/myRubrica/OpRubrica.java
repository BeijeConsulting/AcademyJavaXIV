package it.beije.turing.myRubrica;

import it.beije.turing.rubrica.Contatto;

import java.util.List;

/**
 * @author Giuseppe Raddato
 * Data: 19 apr 2022
 */
public interface OpRubrica {

    public List<Contatto> showContact(Order order);
    public List<Contatto> search(String s);
    public boolean insert(Contatto c);
    public boolean modificaContatto(Contatto c);
    public void deleteContatto(Contatto c);
    public List<Contatto> contattiDuplicati();
    public void unisciContatti();
    public List<Contatto> importFromCVS(String path);
    public List<Contatto> importFromXML(String path);
    public void exportFromCVS(String path,List<Contatto> contatti);
    public void exportFromXML(String path,List<Contatto> contatti);
}
