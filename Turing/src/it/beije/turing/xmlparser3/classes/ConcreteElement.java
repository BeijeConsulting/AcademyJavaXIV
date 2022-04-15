package it.beije.turing.xmlparser3.classes;

import it.beije.turing.xmlparser3.interfaces.Elemento;

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


    public ConcreteElement(String tagName){
        this.tagName=tagName;
    }

    public ConcreteElement(String tagName,String contenuto){
        this(tagName);
        this.contenuto=contenuto;
    }

    public ConcreteElement(String tagName,String contenuto, List<Attributo> attributoList){
        this(tagName,contenuto);
        this.attributoList=attributoList;
    }
    public ConcreteElement(String tagName, List<Attributo> attributoList){
        this(tagName);
        this.attributoList=attributoList;
    }

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
        return this.tagName;
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
    public String toString() {
        return this.tagName;
    }
}
