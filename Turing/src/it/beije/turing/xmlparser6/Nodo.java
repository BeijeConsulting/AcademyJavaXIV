package it.beije.turing.xmlparser6;

import java.util.List;

public abstract class Nodo {
	
	protected List<Attributo> attributi;
	protected String tagName;
	
	public List<Attributo> getAttributi() {
		return attributi;
	}
	public void setAttributi(List<Attributo> attributi) {
		this.attributi = attributi;
	}
	
	
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	
	

} 
