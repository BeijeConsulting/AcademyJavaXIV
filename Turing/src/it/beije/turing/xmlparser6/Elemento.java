package it.beije.turing.xmlparser6;

import java.util.ArrayList;
import java.util.List;


public class Elemento extends Nodo
{
	private Testo textContent;
	private List<Elemento> childElements;
	
	public List<Elemento> getChildElements()
	{
		return childElements;
	}
	
	public void setChildElements(List<Elemento> childElements)
	{
		this.childElements = childElements;
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
}