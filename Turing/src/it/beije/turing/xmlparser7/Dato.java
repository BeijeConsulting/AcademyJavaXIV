package it.beije.turing.xmlparser7;

import java.util.ArrayList;

import org.w3c.dom.Element;

public class Dato {
	
	private String tipo; 
	private String variabile;
	private ArrayList<Argomento> argomenti;
	private Dato(String tipo, String variabile, ArrayList<Argomento> argomenti) {
		this.tipo = tipo;
		this.variabile = variabile;
		this.argomenti = argomenti;
	}
	
	
	
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

	public static Dato newDatoInstance(String string, String string2) {
		String tipo = "";
		String variabile = "";
		ArrayList<Argomento> argomenti = new ArrayList<>();
		if(string.substring(0, string.indexOf(">")).contains(" ")) {
			argomenti = Argomento.argomentoNewInstance(string);
		}
		tipo = string2.substring(1, string2.indexOf(">"));
		variabile = string.substring(string.indexOf(">") + 1).trim();

		return new Dato(tipo, variabile, argomenti);
	}
	
	public String toString() {
		System.out.println("Il tipo di dato è " + tipo);
		System.out.println("Il tipo di variabile è " + variabile);
		for(Argomento argomento: argomenti) {
			argomento.toString();
		}
		return "";
	}
}
