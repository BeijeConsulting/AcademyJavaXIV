package it.beije.turing.xmlparser7;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class Campo implements Element {

	private String campo;
	private ArrayList<Argomento> argomenti;
	private ArrayList<Dato> dato;
	private ArrayList<Campo> campiFigli;
	
////////////////////////////////////////////// COSTRUTTORE ///////////////////////////////////////////////////////////////	
	public Campo(String campo, ArrayList<Argomento> argomenti, ArrayList<Dato> dato, ArrayList<Campo> campiFigli) {

		this.campo = campo;
		this.argomenti = argomenti;
		this.dato = dato;
		this.campiFigli = campiFigli;
	}
	
	
	public String getTagName(){
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
	
	// restituisce un int (fine 
	public static Integer campoNewInstance(String[] splitAllInOne, Integer inizioCampo , Integer fineCampo, ArrayList<Campo> arrayCampi) {
//		String campo = s.substring(0, s.indexOf(" "));
//		s = s.substring(campo.length());
//		
//		campo = campo.trim().replace("<", "");
//		System.out.println(campo);
//		System.out.println(s);
//		String argomento = "";
		ArrayList<Campo> arrayCampiFigli = new ArrayList<Campo>();
		ArrayList<Dato> dato = new  ArrayList<Dato>();
		ArrayList<Argomento> argomenti = new ArrayList<>();
			String campo;
			Integer fine = 0;
			//CASO SENZA ARGOMENTI

			if(splitAllInOne[inizioCampo].indexOf(" ") == -1) {
				//QUI SALVIAMO IL NOME DEL CAMPO
				campo = splitAllInOne[inizioCampo].substring(0, splitAllInOne[inizioCampo].indexOf(">"));
				}
			// CASO IN CUI CI SONO GLI ARGOMENTI
			else {
				campo = splitAllInOne[inizioCampo].substring(0, splitAllInOne[inizioCampo].indexOf(" "));
				argomenti = Argomento.argomentoNewInstance(splitAllInOne[inizioCampo]);
			}
				//Argomento.newArgomentiCampo();
				
				for(int i = inizioCampo + 1 ; i < fineCampo; ) {
					System.out.println("Il valori di i è " + i);
					//a[i] contiene la variabile più il testo, a[i + 1] contiene la variabile che possiamo usare per rimuovere la prima parte del testo per ottenerlo
					if(splitAllInOne[i].length() > campo.length() + 1 && campo.equalsIgnoreCase(splitAllInOne[i].substring(1, campo.length() + 1))) {
						i += 1;
						fine = i;
						break;
					} else if(splitAllInOne[i].substring(0, splitAllInOne[i].indexOf(">")).equalsIgnoreCase(splitAllInOne[i + 1].substring(1, splitAllInOne[i + 1].indexOf(">")))){
						dato.add(Dato.newDatoInstance(splitAllInOne[i], splitAllInOne[i + 1]));
						i += 2;
					} else if(splitAllInOne[i].indexOf(" ") != -1 && splitAllInOne[i].substring(0, splitAllInOne[i].indexOf(" ")).equalsIgnoreCase(splitAllInOne[i + 1].substring(1, splitAllInOne[i + 1].indexOf(">")))) {
						dato.add(Dato.newDatoInstance(splitAllInOne[i], splitAllInOne[i + 1]));
						i += 2;
					} else {
						i = campoNewInstance(splitAllInOne, i, fineCampo, arrayCampiFigli);

					}
				
			}

		System.out.println("Il ciclo è stato completato.");
			arrayCampi.add(new Campo(campo, argomenti, dato, arrayCampiFigli));
			return fine;
		}

	public String toString() {
		System.out.println(campo);
		for(Argomento argomento: argomenti) {
			argomento.toString();
		}

		for(Campo campo1: campiFigli) {
			campo1.toString();
		}
		return "";
	}

	public ArrayList<Argomento> getAttributes() {
		return argomenti;
	}

	public String getAttribute(String attribute) {
		for(Argomento argomento: argomenti) {
			if(argomento.getArgomento().equalsIgnoreCase(attribute)) {
				return argomento.getContenuto();
			}
		}return null;
	} //torna il valore dell'attributo specificato
	
	//public ArrayList<Dato> cercaDati( String[] splitAllInOne, )

	public int getElementsByTagName(String tagName) {
		int i = 0;

		if(campo.equalsIgnoreCase(tagName)) {
			i++;
		}

		for(Campo campo1: campiFigli) {
			i += campo1.getElementsByTagName(tagName);
		}

		for(Dato dato1: dato) {
			i += dato1.getElementsByTagName(tagName);
		}

		return i;
	}


	@Override
	public ArrayList<Element> getChildElements() {
		ArrayList<Element> elements = new ArrayList<Element>();

		for(Campo c : campiFigli) {
			elements.add(c);
		}

		for(Dato d : dato){
			elements.add(d);
		}
		return elements;

	}
}