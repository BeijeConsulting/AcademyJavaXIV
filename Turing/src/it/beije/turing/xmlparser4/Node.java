package it.beije.turing.xmlparser4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Node  {

    private String name="";
    private List <Attributes> attributes=new ArrayList<>();
    private List <Node> children=new ArrayList<>();
    private String content="";

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
    	StringBuilder builder = new StringBuilder();
    	builder.append(content+" ");
    	if(this.hasChildren())
    	{
    		for(Node n :this.children)
    		{
    			builder.append(n.getTextContent());
    		}
    	}
        return builder.toString();
    }
    public boolean hasAttributes()
    {
    	if(attributes.isEmpty())
    	{
    		return false;
    	}
    	return true;
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

    public String getAttribute(String attribute) {
        String attValue= null;

            for (Attributes attr : this.attributes) {
                if (attr.getName().equals(attribute)) {
                    attValue=attr.getValue();
                }
            }
         if (attValue==null) {
             return "";
         }
        return attValue;
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
    				n.recursiveTagSearch(tmp,tagName);
    			}
    		}
    		return tmp;
    }
    private void recursiveTagSearch(List<Node> tmp,String tagName)
    {
    	if(this.getTagName().equals(tagName))
    	{
    		tmp.add(this);
    	}
    	else if(this.hasChildren())
    	{
    		for(Node child:this.getChildElements())
    		{
    			child.recursiveTagSearch(tmp, tagName);
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
    public String toString()
    {
    	return("nome:"+name);
    }
}
