package it.beije.turing.xmlparser3.interfaces;

import java.util.List;

/**
 * @author Giuseppe Raddato
 * Data: 14 apr 2022
 */
public interface IElementoNode {
    String getTagName(); //torna il nome del tag

    List<String> getAttributes(); //torna l'elenco degli attributi dell'elemento
    String getAttribute(String attribute); //torna il valore dell'attributo specificato
}
