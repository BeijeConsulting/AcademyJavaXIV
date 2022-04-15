package it.beije.turing.xmlparser7;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class Campo implements Element {

	private String campo;
	private ArrayList<Argomento> argomenti;
	private ArrayList<Element> elementi;

	
////////////////////////////////////////////// COSTRUTTORE ///////////////////////////////////////////////////////////////	
	public Campo(String campo, ArrayList<Argomento> argomenti, ArrayList<Element> elementi) {

		this.campo = campo;
		this.argomenti = argomenti;
		this.elementi = elementi;
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
	
	public ArrayList<Element> getElementi() {
		return elementi;
	}
	public void setElementi(ArrayList<Element> elementi) {
		this.elementi = elementi;
	}
	
	// restituisce un int (fine 
	public static Integer campoNewInstance(String[] splitAllInOne, Integer inizioCampo , Integer fineCampo, ArrayList<Element> arrayElementi) {
//		String campo = s.substring(0, s.indexOf(" "));
//		s = s.substring(campo.length());
//		
//		campo = campo.trim().replace("<", "");
//		System.out.println(campo);
//		System.out.println(s);
//		String argomento = "";
		ArrayList<Element> elementi = new ArrayList<Element>();
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
					//a[i] contiene la variabile più il testo, a[i + 1] contiene la variabile che possiamo usare per rimuovere la prima parte del testo per ottenerlo
					if(splitAllInOne[i].length() > campo.length() + 1 && campo.equalsIgnoreCase(splitAllInOne[i].substring(1, campo.length() + 1))) {
						i += 1;
						fine = i;
						break;
					} else if(splitAllInOne[i].substring(0, splitAllInOne[i].indexOf(">")).equalsIgnoreCase(splitAllInOne[i + 1].substring(1, splitAllInOne[i + 1].indexOf(">")))){
						elementi.add(Dato.newDatoInstance(splitAllInOne[i], splitAllInOne[i + 1]));
						i += 2;
					} else if(splitAllInOne[i].indexOf(" ") != -1 && splitAllInOne[i].substring(0, splitAllInOne[i].indexOf(" ")).equalsIgnoreCase(splitAllInOne[i + 1].substring(1, splitAllInOne[i + 1].indexOf(">")))) {
						elementi.add(Dato.newDatoInstance(splitAllInOne[i], splitAllInOne[i + 1]));
						i += 2;
					} else {
						i = campoNewInstance(splitAllInOne, i, fineCampo, elementi);

					}
				
			}

		arrayElementi.add(new Campo(campo, argomenti, elementi));
			return fine;
		}

	public String toString() {
		System.out.println(campo);
		for(Argomento argomento: argomenti) {
			argomento.toString();
		}

		for(Element element: elementi) {
			element.toString();
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

		for(Element element: elementi) {
			i += element.getElementsByTagName(tagName);
		}

		return i;
	}

	@Override
	public String getTextContent() {
		String s = "";
		for(Element element: elementi) {
			s += element.getTextContent() + "\n";
		}
		return s;
	}


	@Override
	public ArrayList<Element> getChildElements() {
		ArrayList<Element> elements = new ArrayList<Element>();

		for(Element element: elementi) {
			elements.add(element);
		}

		return elements;

	}
}