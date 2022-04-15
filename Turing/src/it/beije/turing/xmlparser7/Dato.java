package it.beije.turing.xmlparser7;

import java.util.ArrayList;

public class Dato implements Element {
	
	private String tipo; 
	private String variabile;
	private ArrayList<Argomento> argomenti;
	private Dato(String tipo, String variabile, ArrayList<Argomento> argomenti) {
		this.tipo = tipo;
		this.variabile = variabile;
		this.argomenti = argomenti;
	}
	
	
	
	public String getTagName() {
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

	public ArrayList<Argomento> getAttributes() {
		return argomenti;
	}

	@Override
	public int getElementsByTagName(String tagName) {
		int i = 0;

		if (tipo.equalsIgnoreCase(tagName)) {
			i++;
		}

		return i;
	}

	public String getAttribute(String attribute) {
		for(Argomento argomento: argomenti) {
			if(argomento.getArgomento().equalsIgnoreCase(attribute)) {
				return argomento.getContenuto();
			}
		}return null;
	}



	@Override
	public ArrayList<Element> getChildElements() {
		return null;
	}
}
