package it.beije.turing.xmlparser3.classes;

import it.beije.turing.xmlparser3.Exception.AttributeNonFound;
import it.beije.turing.xmlparser3.interfaces.Elemento;

import java.util.ArrayList;
import java.util.List;


public class ConcreteElement implements Elemento {
    private String tagName;
    private String contenuto;
    private List<Attributo> attributoList=new ArrayList<>();
    public String getAttribute(String attribute){
        System.out.println(attributoList.size());
        if(attributoList.isEmpty()){
            throw new AttributeNonFound(attribute);
        } else{
            for (Attributo attr : attributoList) {
                if(attr.getName().equals(attribute)){
                    return attr.getValue();
                }
            }
            throw new AttributeNonFound(attribute);
        }
    }



    private TreeNode<Elemento> rootNode;



    public TreeNode<Elemento> getRootNode() {
        return rootNode;
    }

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
    public void setTextContent(String s) {
        this.contenuto=s;
    }

    @Override
    public String getTextContent() {
        return this.contenuto;
    }

    @Override
    public void setNode(TreeNode<Elemento> rootNode) {
        this.rootNode=rootNode;
    }

    @Override
    public List<TreeNode<Elemento>> getChildNodes() {
        return  this.rootNode.getChildren();
    }

    @Override
    public String toString() {
        return "ConcreteElement{" +
                "tagName='" + tagName + '\'' +
                ", contenuto='" + contenuto + '\'' +
                ", attributoList=" + attributoList +
                '}';
    }
}
