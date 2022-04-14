package it.beije.turing.xmlparser1.ConcreteClass;

import java.util.List;

import it.beije.turing.xmlparser1.Interfaces.Elemento;

public class ElementoConcreto extends NodoConcreto implements Elemento {
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

	@Override
	public List<NodoConcreto> getChildNodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTestoCompleto() {
		return testoCompleto;
	}

	
}
