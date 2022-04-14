package it.beije.turing.xmlparser7;

import java.util.ArrayList;

public class Dato {
	
	private String tipo; 
	private String variabile;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getVariabile() {
		return variabile;
	}
	public void setVariabile(String variabile) {
		this.variabile = variabile;
	}
	
	private Dato(String tipo, String variabile) {
		this.tipo = tipo;
		this.variabile = variabile;
	}
	
	public Dato newInstanceDato(String s) {
		String tipo = impostaTipo(s);
		String variabile = impostaVariabile(s);
		
		return new Dato(tipo, variabile);
	}
	
	private String impostaTipo(s) {
		<nome>
			ciao
		</nome>
	}
}
