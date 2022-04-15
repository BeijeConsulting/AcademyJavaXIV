package it.beije.turing.xmlparser3.interfaces;


import it.beije.turing.xmlparser3.classes.Attributo;

import java.util.List;

/**
 * @author Giuseppe Raddato
 * Data: 14 apr 2022
 */
public interface Elemento extends Node {
    public  void setAttributi(Attributo a);
    public List<Attributo> getAttributi();

    public  void setTagName(String name);
    public  String getTagName();

    public  void setContent(String s);
    public  String getContent();

}
