package it.beije.turing.xmlparser6;

import java.util.List;

public abstract class Nodo
{
	protected String tagName;
	private List<Attributo> attributes;
	private List<Nodo> childNodes;
	private Nodo parent;
	
	public abstract String getTagName();	
	public abstract void setTagName(String tagName);
	
	
	public List<Attributo> getAttributes()
	{
		return attributes;
	}
	
	public String getAttribute(String attribute)
	{
		for(Attributo attr : attributes)
		{
			if(attr.getNome().equals(attribute)) return attr.getValore();
		}
		
		return null;
	}
	
	public void setAttributes(List<Attributo> attributes)
	{
		this.attributes = attributes;
	}
	
	
	public List<Nodo> getChildNodes()
	{
		return childNodes;
	}
	
	public void setChildNodes(List<Nodo> childNodes)
	{
		this.childNodes = childNodes;
	}
	
	
	public void setParent(Nodo parent)
	{
		this.parent = parent;
	}
	
	public Nodo getParent()
	{
		return parent;
	}
}