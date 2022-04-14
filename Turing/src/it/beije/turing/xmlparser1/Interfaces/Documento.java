package it.beije.turing.xmlparser1.Interfaces;

import java.util.List;

public interface Documento {
	public abstract Elemento getDocumentElement();
	public List<String> getTestoTotale();
	public void setTestoTotale(List<String> testoTotale);
}
