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

    public void getChildNodes() {

    }


    public void getChildElements() {

    }

    public void getTagName() {

    }

    public void getTextContent() {

    }

    public void getAttributes() {

    }
}
