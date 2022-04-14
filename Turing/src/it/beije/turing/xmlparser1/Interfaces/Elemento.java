package it.beije.turing.xmlparser1.Interfaces;

import java.util.List;
import java.util.Map;

import it.beije.turing.xmlparser1.ConcreteClass.Attributo;

public interface Elemento extends Nodo{
	public String getTagName();
	public void setTagName(String tagName);
	public String getTextContent();
	public void setTextContent(String textContent);
	public List<Elemento> getElementsByTagName(String tagName, List<Elemento> ris, int level);
	public Map<String,Attributo> getAttributes();
	public String getAttribute(String attribute);
	public void setAttributes(Map<String,Attributo> attributes);
}
