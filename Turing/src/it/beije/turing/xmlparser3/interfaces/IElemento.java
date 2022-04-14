package it.beije.turing.xmlparser3.interfaces;

import it.beije.turing.xmlparser3.classes.Elemento;
import it.beije.turing.xmlparser3.classes.Nodo;

import java.util.List;

/**
 * @author Giuseppe Raddato
 * Data: 14 apr 2022
 */
public interface IElemento {
    public List<String> getAttributes();
    public List<Nodo> getChildNodes();
    public String getTagName();
    public String getTextContent();
    public String getAttribute(String attr);
    public List<Elemento> getElementsByTagName(String nome);
}
