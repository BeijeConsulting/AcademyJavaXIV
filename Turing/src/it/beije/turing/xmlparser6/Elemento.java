package it.beije.turing.xmlparser6;

import java.util.ArrayList;
import java.util.List;


public class Elemento extends Nodo
{
	private Testo textContent;
	private List<Elemento> childElements = new ArrayList<>();
	private Elemento parent;
	
	public List<Elemento> getChildElements()
	{
		return childElements;
	}
	
	public void setChildElements(Elemento childElement)
	{
		this.childElements.add(childElement);
	}
	
	
	public List<Elemento> getElementsByTagName(String tagName)
	{
		List<Elemento> lista = new ArrayList<>();
		
		for(Elemento el : childElements)
		{
			if(el.getTagName().equals(tagName)) lista.add(el);
		}
		
		return lista;
	}
	
	public void setTextContent(Testo textContent)
	{
		this.textContent = textContent;
	}
	
	public String getTextContent()
	{
		return textContent.getTesto();
	}

	@Override
	public String getTagName() 
	{
		return tagName;
	}

	@Override
	public void setTagName(String tagName)
	{
		this.tagName = tagName;
	}
	
	public void setParent(Elemento parent)
	{
		this.parent = parent;
	}
	
	public Elemento getParent()
	{
		return parent;
	}
}