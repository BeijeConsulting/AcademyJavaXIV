package it.beije.turing.xmlparser1.Interfaces;

import java.util.List;

public interface Elemento extends Nodo{
	public String getTagName();
	public void setTagName(String tagName);
	public String getTextContent();
	public void setTextContent(String textContent);
	public List<Elemento> getElementsByTagName(String tagName, List<Elemento> ris, int level);
}
