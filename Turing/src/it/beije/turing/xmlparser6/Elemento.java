package it.beije.turing.xmlparser6;

import java.util.List;

public class Elemento {
	private String name;
	private List<Attributi> attribute;
	private String testo;
	private String listaEL;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<Attributi> getAttribute() {
		return attribute;
	}
	
	public void setAttribute(List<Attributi> attribute) {
		this.attribute = attribute;
	}
	
	
	public String getTesto() {
		return testo;
	}
	
	public void setTesto(String testo) {
		this.testo = testo;
	}
	
	
	public String getListaEL() {
		return listaEL;
	}
	public void setListaEL(String listaEL) {
		this.listaEL = listaEL;
	}
	
	
	

}
