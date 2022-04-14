package it.beije.turing.xmlparser4;

import java.util.ArrayList;
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

    public List<Node> getChildElements() {
        return this.children;
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

    public void addChild(Node node){
    	if(children==null)
    	{
    		children=new ArrayList<>();
    	}
        this.children.add(node);
    }

    public List<Node> getElementsByTagName(String tagName) {
    	List<Node> tmp = new ArrayList<>();
    	if(this.getTagName().equals(tagName))
    	{
    		tmp.add(this);
    	}
    		if(hasChildren())
    		{
    			for(Node n : getChildNodes())
    			{
    				n.recursiveSearch(tmp,tagName);
    			}
    		}
    		return tmp;
    }
    private void recursiveSearch(List<Node> tmp,String tagName)
    {
    	if(this.getTagName().equals(tagName))
    	{
    		tmp.add(this);
    	}
    	else if(this.hasChildren())
    	{
    		for(Node child:this.getChildElements())
    		{
    			child.recursiveSearch(tmp, tagName);
    		}
    	}
    	else return;
    }
    public boolean hasChildren()
    {
    	if(children!=null&&!children.isEmpty())
    	{
    		return true;
    	}
    	return false;
    }
}
