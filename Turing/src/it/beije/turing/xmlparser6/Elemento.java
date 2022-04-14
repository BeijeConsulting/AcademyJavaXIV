package it.beije.turing.xmlparser6;

import java.util.ArrayList;
import java.util.List;


public class Elemento extends Nodo{
	
	private Testo testo;
	private List<Elemento> childElements;
	private List<Nodo> childNodes;

	public List<Elemento> getChildElements()
	{
		return childElements;
	}
	
	public void setChildElements(List<Elemento> childElements)
	{
		this.childElements = childElements;
	}
	
	
	public List<Nodo> getChildNodes()
	{
		return childNodes;
	}
	
	public void setChildNodes()
	{
		List<Nodo> temp = new ArrayList<>();
		
		for(Elemento e : getChildElements())
		{
			temp.add(e);
		}
		
		temp.add(testo);
		
		this.childNodes = temp;
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
	
	public String getTextContent()
	{
		return testo.getTesto();
	}
}