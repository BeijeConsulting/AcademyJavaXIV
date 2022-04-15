package it.beije.turing.xmlparser6;

import java.util.List;

public class XMLDocument
{
	private Prolog prologElement;				//intestazione xml. potrebbe non esistere
	private Elemento rootElement;				//elemento di root del documento xml
	private List<Elemento> listElement;
	
	
	//SETTERs
	public void setPrologElement(Prolog prologElement)
	{
		this.prologElement = prologElement;
	}
	
	public void setRootElement(Elemento rootElement)
	{
		this.rootElement = rootElement;
	}
	
	public void setListElement(List<Elemento> listElement)
	{
		this.listElement = listElement;
	}
	
	
	//GETTERs
	public Prolog getPrologElement()
	{
		return prologElement;
	}
	
	public Elemento getRootElement()
	{
		return rootElement;
	}
	
	public List<Elemento> getListElement()
	{
		return listElement;
	}
}