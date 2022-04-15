package it.beije.turing.xmlparser3.interfaces;


import java.util.List;

/**
 * @author Giuseppe Raddato
 * Data: 14 apr 2022
 */
public interface Node{
    List<Node> getListChiled();
    void setListChiled(Node node);

    Elemento getElementsByTagName(String nome);
}
