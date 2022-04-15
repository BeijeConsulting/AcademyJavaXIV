package it.beije.turing.xmlparser4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Node  {

    private String name="";
    private List <Attributes> attributes= new ArrayList<>();
    private List <Node> children=new ArrayList<>();
    private String content="";

    public Node(String name, List<Attributes> attributes, String content) {
        this.name = name;
        if(attributes!=null) {
        this.attributes = attributes;
        }
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
    	StringBuilder builder = new StringBuilder("<"+name+(hasAttributes()?" "+printAttributes():"")+">\n"+content+"\n");
    		if(this.hasChildren())
    	{
    		for(Node n :this.children)
    		{
    			builder.append(n.getTextContent());
    		}
    	}
    	builder.append("</"+name+">\n");
        return builder.toString();
    }
    private String printAttributes() {
    	StringBuilder s = new StringBuilder();
		if(hasAttributes())
		{
			for(Attributes a : attributes)
			{
				s.append(a);
			}
		}
		return s.toString();
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
        String attValue= "";

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
    	StringBuilder builder = new StringBuilder("<"+name+">\n"+content+"\n"+"</"+name+">");
    	return builder.toString();
    	
    }
    
}
