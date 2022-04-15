package it.beije.turing.xmlparser3.classes;

import it.beije.turing.xmlparser3.interfaces.Elemento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class TreeNode<T> {
    private final List<TreeNode<T>> children;
    private TreeNode<T> parent;
    private T data;
    private int depth;

    public TreeNode(T data) {
        // a fresh node, without a parent reference
        this.children = new ArrayList<>();
        this.parent = null;
        this.data = data;
        this.depth = 0; // 0 is the base level (only the root should be on there)
    }

    public TreeNode(T data, TreeNode<T> parent) {
        // new node with a given parent
        this.children = new ArrayList<>();
        this.data = data;
        this.parent = parent;
        this.depth = (parent.getDepth() + 1);
        parent.addChild(this);
    }

    public int getDepth() {
        return this.depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public List<T> getChildElements() {
            List<T> elementoList= new ArrayList<>();
            for(TreeNode<T> child : children) {
                    elementoList.add(child.getData());
            }
            return elementoList;
    }

    public List<Elemento> getElementsByTagName(String tagName){
        List<Elemento> c= (List<Elemento>) getChildElements();
        List<Elemento> elementoList= new ArrayList<>();
        for(Elemento child :c) {
            if(child.getTagName().equals(tagName)){
                elementoList.add(child);
            }
        }
        return elementoList;
    }
    public void setParent(TreeNode<T> parent) {
        this.setDepth(parent.getDepth() + 1);
        parent.addChild(this);
        this.parent = parent;
    }

    public TreeNode<T> getParent() {
        return this.parent;
    }

    public void addChild(T data) {
        TreeNode<T> child = new TreeNode<>(data);
        this.children.add(child);
    }

    public void addChild(TreeNode<T> child) {
        this.children.add(child);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isRootNode() {
        return (this.parent == null);
    }

    public boolean isLeafNode() {
        return (this.children.size() == 0);
    }

    public void removeParent() {
        this.parent = null;
    }

    @Override
    public String toString() {
        String result = "";
        result += "Nodo: " + this.getData().toString() + " | Profondita: " + this.depth + " | Parente: " + (this.getParent() == null ? "None" : this.parent.getData().toString()) + " | Figli: " + (this.getChildren().size() == 0 ? "None" : "");
       for(TreeNode<T> child : this.getChildren()) {
            result += "\n\t" + child.getData().toString() + " | Parente: " + (child.getParent() == null ? "None" : child.getParent().getData());
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode<Elemento> rootContatti = new TreeNode<>(new ConcreteElement("Contatti"));
        TreeNode<Elemento> rootContatto = new TreeNode<>(new ConcreteElement("Contatto"), rootContatti);
        TreeNode<Elemento> nome = new TreeNode<>(new ConcreteElement("Nome","Pippo"), rootContatto);
        TreeNode<Elemento> cognome = new TreeNode<>(new ConcreteElement("Cognome","Puto"), rootContatto);
        TreeNode<Elemento> tel = new TreeNode<>(new ConcreteElement("Telefono","1232321"), rootContatto);
        TreeNode<Elemento> email = new TreeNode<>(new ConcreteElement("Mail","pippo@pluto.com"), rootContatto);

        System.out.println(rootContatti);

        //System.out.println(rootContatto);


        System.out.println(nome);
        System.out.println(cognome);
        System.out.println(email);
        System.out.println(tel);

        System.out.println("Is rootNode a root node? - " + rootContatti.isRootNode());
        System.out.println("Is firstNode a root node? - " + rootContatto.isRootNode());

    }
}
