package it.beije.turing.xmlparser6;

public class XMLDocument
{
	private Prolog prolog;			//intestazione xml. potrebbe non esistere
	private Elemento root;			//elemento di root del documento xml
	
	
	public void setProlog(Prolog prolog)
	{
		this.prolog = prolog;
	}
	
	public void setRoot(Elemento root)
	{
		this.root = root;
	}
	
	public Prolog getProlog()
	{
		return prolog;
	}
	
	public Elemento getRoot()
	{
		return root;
	}
}