package it.beije.turing.xmlparser3.classes;

import it.beije.turing.xmlparser3.interfaces.IElemento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Giuseppe Raddato
 * Data: 14 apr 2022
 */
public class Elemento implements IElemento {

    private String tagName;
    private List<Elemento> elementoList=new ArrayList<>();


    private void setElemento(Elemento o){
        elementoList.add(o);
    }


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
        return this.tagName;
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
        List<Elemento> result=new ArrayList<>();

        for (Elemento e:elementoList) {
            if(e.getTagName().equalsIgnoreCase(nome)){
                result.add(e);
            }
        }
        return result;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
