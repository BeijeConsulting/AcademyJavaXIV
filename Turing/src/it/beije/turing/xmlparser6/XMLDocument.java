package it.beije.turing.xmlparser6;

public class XMLDocument
{
	private Prolog prologElement;				//intestazione xml. potrebbe non esistere
	private Elemento rootElement;				//elemento di root del documento xml
	
	
	//SETTERs
	public void setPrologElement(Prolog prologElement)
	{
		this.prologElement = prologElement;
	}
	
	public void setRootElement(Elemento rootElement)
	{
		this.rootElement = rootElement;
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
}