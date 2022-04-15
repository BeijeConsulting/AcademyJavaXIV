package it.beije.turing.xmlparser3.classes;

import it.beije.turing.xmlparser3.interfaces.Elemento;
import it.beije.turing.xmlparser3.interfaces.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Giuseppe Raddato
 * Data: 14 apr 2022
 */
public class ConcreteElement implements Elemento {
    private String tagName;
    private String contenuto;
    private List<Attributo> attributoList=new ArrayList<>();
    private List<Node> childList=new ArrayList<>();

    @Override
    public void setAttributi(Attributo a) {
        attributoList.add(a);

    }

    @Override
    public List<Attributo> getAttributi() {
        return this.attributoList;
    }

    @Override
    public void setTagName(String name) {
        this.tagName=name;

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public void setContent(String s) {
        this.contenuto=s;
    }

    @Override
    public String getContent() {
        return this.contenuto;
    }

    @Override
    public List<Node> getListChiled() {
        return this.childList;
    }

    @Override
    public void setListChiled(Node node) {
        this.childList.add(node);
    }

    @Override
    public Elemento getElementsByTagName(String nome) {
        //TODO
        return null;
    }
}
