package it.beije.turing.xmlparser1.ConcreteClass;

import it.beije.turing.xmlparser1.Interfaces.Elemento;

public class ElementoConcreto extends Nodo implements Elemento {
	private String tagName;
	private String textContent;
	
	public ElementoConcreto(String testoCompleto) {
		super(testoCompleto);
		tagName = "";
		textContent = "";
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}
	
	
}
