package it.beije.turing.xmlparser6;

import java.util.List;

public class Elemento extends Nodo{
	
	private String testo;
	private List<Elemento> listaEL;

	
	public String getTesto() {
		return testo;
	}
	
	public void setTesto(String testo) {
		this.testo = testo;
	}
	
	
	public List<Elemento> getListaEL() {
		return listaEL;
	}
	public void setListaEL(List<Elemento> listaEL) {
		this.listaEL = listaEL;
	}
	
	
	

}
