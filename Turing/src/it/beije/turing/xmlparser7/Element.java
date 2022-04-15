package it.beije.turing.xmlparser7;

import java.util.ArrayList;

public interface Element {

    ArrayList<Element> getChildElements();

    String getTagName();

    String getAttribute(String attribute);

    ArrayList<Argomento> getAttributes();

    int getElementsByTagName(String tagName);


}
