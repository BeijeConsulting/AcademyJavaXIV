package it.beije.turing.xmlparser3.classes;

import it.beije.turing.xmlparser3.interfaces.IElemento;

import java.util.List;

/**
 * @author Giuseppe Raddato
 * Data: 14 apr 2022
 */
public class Elemento implements IElemento {

    @Override
    public List<String> getAttributes() {
        return null;
    }

    @Override
    public List<Nodo> getChildNodes() {
        return null;
    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getTextContent() {
        return null;
    }

    @Override
    public String getAttribute(String attr) {
        return null;
    }

    @Override
    public List<Elemento> getElementsByTagName(String nome) {
        return null;
    }
}
