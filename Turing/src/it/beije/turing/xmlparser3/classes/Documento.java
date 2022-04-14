package it.beije.turing.xmlparser3.classes;

import it.beije.turing.xmlparser3.interfaces.XMLParser;

import javax.xml.bind.Element;
import java.util.List;

/**
 * @author Giuseppe Raddato
 * Data: 14 apr 2022
 */
public class Documento extends LoadFile implements XMLParser{

    @Override
    public ElementNode getRootElement() {
        return null;
    }

    @Override
    public List<ElementNode> getChildNodes() {
        return null;
    }

    @Override
    public Element getChildElements() {
        return null;
    }

    @Override
    public List<Element> getElementsByTagName(String tagName) {
        return null;
    }
}
