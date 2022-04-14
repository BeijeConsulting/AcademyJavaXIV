package it.beije.turing.xmlparser1.Interfaces;

public interface Elemento extends Nodo{
	public String getTagName();
	public void setTagName(String tagName);
	public String getTextContent();
	public void setTextContent(String textContent);
	public String getTestoTotale();
}
