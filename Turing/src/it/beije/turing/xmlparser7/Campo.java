package it.beije.turing.xmlparser7;

import java.util.ArrayList;

public class Campo {

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
			String campo;
			Integer fine = 0;
			//CASO SENZA ARGOMENTI

			if(splitAllInOne[inizioCampo].indexOf(" ") == -1) {
				//QUI SALVIAMO IL NOME DEL CAMPO
				System.out.println("Sono dopo questo " + splitAllInOne[inizioCampo] + "Sono prima di questo");
				campo = splitAllInOne[inizioCampo].substring(0, splitAllInOne[inizioCampo].indexOf(">"));
				}
			// CASO IN CUI CI SONO GLI ARGOMENTI
			else {
				campo = splitAllInOne[inizioCampo].substring(0, splitAllInOne[inizioCampo].indexOf(" "));

			}
				//Argomento.newArgomentiCampo();
				
				for(int i = inizioCampo + 1 ; i < fineCampo; ) {
					//a[i] contiene la variabile più il testo, a[i + 1] contiene la variabile che possiamo usare per rimuovere la prima parte del testo per ottenerlo
					System.out.println("Il valore di i è " + i);
					System.out.println("Il valore di campo è " + campo);
					if(splitAllInOne[i].length() > campo.length() + 1 && campo.equalsIgnoreCase(splitAllInOne[i].substring(1, campo.length() + 1))) {
						System.out.println("Il valore di campo è " + campo + " il valore dell'altro campo è " + splitAllInOne[i].substring(1, campo.length() + 1));
						i += 1;
						fine = i;
						break;
					} else if(splitAllInOne[i].substring(0, splitAllInOne[i].indexOf(">")).equalsIgnoreCase(splitAllInOne[i + 1].substring(1, splitAllInOne[i + 1].indexOf(">")))){
						dato.add(newDatoInstance(splitAllInOne[i].substring(0, splitAllInOne[i].indexOf(">")), splitAllInOne[i + 1].substring(1, splitAllInOne[i + 1].indexOf(">"))));
						i += 2;
					} else if(splitAllInOne[i].indexOf(" ") != -1 && splitAllInOne[i].substring(0, splitAllInOne[i].indexOf(" ")).equalsIgnoreCase(splitAllInOne[i + 1].substring(1, splitAllInOne[i + 1].indexOf(">")))) {
						dato.add(newDatoInstance(splitAllInOne[i].substring(0, splitAllInOne[i].indexOf(" ")), splitAllInOne[i + 1].substring(1, splitAllInOne[i + 1].indexOf(">"))));
						i += 2;
					} else {
						i = campoNewInstance(splitAllInOne, i, fineCampo, arrayCampiFigli);

					}
				
			}

		System.out.println("Il ciclo è stato completato.");
			arrayCampi.add(new Campo(campo, null, dato, arrayCampiFigli));
			return fine;
		}
	
	

	
	
	
	private static Dato newDatoInstance(String string, String string2) {
		System.out.println("Ho inserito il dato " + string + " con il dato " + string2);
		return null;
		// TODO Auto-generated method stub
		
	}

	public String toString() {
		System.out.println(campo);
		for(Campo c: campiFigli) {
			c.toString();
		}
		return "";
	}
	
	//public ArrayList<Dato> cercaDati( String[] splitAllInOne, )
	
	
}