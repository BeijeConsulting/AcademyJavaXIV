package it.beije.turing.xmlparser3.interfaces;

import it.beije.turing.xmlparser3.classes.ElementNode;

import javax.xml.bind.Element;
import java.util.List;

/**
 * @author Giuseppe Raddato
 * Data: 14 apr 2022
 */
public interface XMLParser{
    ElementNode getRootElement(); //torna l'elemento root
    List<ElementNode> getChildNodes(); //torna tutti i nodi "figli" interni all'elemento su cui viene eseguito
    Element getChildElements(); //torna i soli elementi figli dell'elemento su cui viene eseguito
    List<Element> getElementsByTagName(String tagName); //torna TUTTI gli elementi con quello specifico nome


}
