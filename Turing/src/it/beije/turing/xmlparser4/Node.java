package it.beije.turing.xmlparser4;

import java.util.List;

public class Node  {

    String name;
    List <Attributes> attributes;
    List <Node> children;
    String content;

    public Node(String name, List<Attributes> attributes, String content) {
        this.name = name;
        this.attributes = attributes;
        this.content=content;
    }

    public Node(String name) {
        this(name, null, null);
    }

    public Node(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public List<Node> getChildNodes() {
        return this.children;
    }


    public void getChildElements() {
    }

    public String getTagName() {
        return this.name;
    }

    public String getTextContent() {
        return this.content;
    }

    public List<Attributes> getAttributes() {
        return this.attributes;
    }
}
