package it.beije.turing.xmlparser1.ConcreteClass;

import java.util.List;

import it.beije.turing.xmlparser1.Interfaces.Nodo;

public class NodoConcreto implements Nodo{
	protected String testoCompleto;
	
	public NodoConcreto(String testoCompleto) {
		this.testoCompleto = testoCompleto;
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
