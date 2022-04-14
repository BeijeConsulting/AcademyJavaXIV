package it.beije.turing.xmlparser7;

import java.util.ArrayList;

public class Campo {

	private String campo;
	private ArrayList<Argomento> argomenti;
	private ArrayList<Dato> dato;
	private ArrayList<Campo> campiFigli;
	
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	
	public ArrayList<Argomento> getArgomenti() {
		return argomenti;
	}
	public void setArgomenti(ArrayList<Argomento> argomenti) {
		this.argomenti = argomenti;
	}
	
	public ArrayList<Dato> getDato() {
		return dato;
	}
	public void setDato(ArrayList<Dato> dato) {
		this.dato = dato;
	} 
	
	public ArrayList<Campo> getCampiFigli() {
		return campiFigli;
	}
	public void setCampiFigli(ArrayList<Campo> campiFigli) {
		this.campiFigli = campiFigli;
	}
	
	
	public static void campoNewInstance(String s) {
//		String campo = s.substring(0, s.indexOf(" "));
//		s = s.substring(campo.length());
//		
//		campo = campo.trim().replace("<", "");
//		System.out.println(campo);
//		System.out.println(s);
//		String argomento = "";
	}
}
