package it.beije.turing.xmlparser6;

import java.util.List;

public abstract class Nodo
{
	protected List<Attributo> attributes;
	protected String tagName;
	protected Elemento father;
	
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
	
	
	public String getTagName()
	{
		return tagName;
	}
	
	public void setTagName(String tagName)
	{
		this.tagName = tagName;
	}
}