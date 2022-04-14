package it.beije.turing.xmlparser6;

import java.util.List;

public class Prolog {
	private String nome;
	private List<Attributi> attribute;
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(List<Attributi> a) {
		this.nome = "<?xml " + a + "?>";
	}
	
	
	public List<Attributi> getAttribute() {
		return attribute;
	}
	
	public void setAttribute(List<Attributi> attribute) {
		this.attribute = attribute;
	}
	
	

}
