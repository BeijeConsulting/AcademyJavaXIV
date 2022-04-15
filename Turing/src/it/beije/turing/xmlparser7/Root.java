package it.beije.turing.xmlparser7;

import java.util.ArrayList;

public class Root implements Element {

	private String rootName;
	private ArrayList<Element> campi;
	private Integer inizioCampi;
	private Integer fineCampi;

	private ArrayList<Argomento> argomenti = new ArrayList<>();

	
	public Root(String rootName, ArrayList<Element> campi, Integer inizioCampi, Integer fineCampi) {
		this.rootName = rootName;
		this.campi = campi;
		this.inizioCampi = inizioCampi;
		this.fineCampi = fineCampi;
	}



	public String getTagName() {
		return rootName;
	}

	@Override
	public String getAttribute(String attribute) {
		for(Argomento argomento: argomenti) {
			if(argomento.getArgomento().equalsIgnoreCase(attribute)) {
				return argomento.getContenuto();
			}
		}return null;
	}

	@Override
	public ArrayList<Argomento> getAttributes() {
		return argomenti;
	}

	public void setRootName(String root) {
		this.rootName = root;
	}

	public ArrayList<Element> getCampi() {
		return campi;
	}

	public void setCampi(ArrayList<Element> campi) {
		this.campi = campi;
	}
	
	public static Root creaInstanzaRoot(String[] splitAllInOne) {
		boolean dichiarazioneTrovata = false;
		int inizioCampi = 0;
		int fineCampi = 0;
		String name = "";
		ArrayList<Element> campi = new ArrayList<>();
		ArrayList<Argomento> argomenti = new ArrayList<>();
		
		// cercando l'inizio splitAllInOne[i].indexOf("?>")
		for(int i = 0; i < splitAllInOne.length; i++) {
			if(splitAllInOne[i].length()> 0 && splitAllInOne[i].indexOf("?>") != -1) {
				if(splitAllInOne[i].substring(splitAllInOne[i].indexOf("?>"),splitAllInOne[i].indexOf("?>")+ "?>".length()).equalsIgnoreCase("?>")) {
					name = splitAllInOne[i + 1].substring(0, splitAllInOne[i + 1].indexOf(">"));
					if(name.contains(" ")) {
						argomenti = Argomento.argomentoNewInstance(splitAllInOne[i + 1]);
						name = name.substring(0, name.indexOf(" "));
					}
					inizioCampi = i + 2;
					dichiarazioneTrovata = true;
					break;
				}
			}
		}
		
		
		// Cerchiamo la fine 
		for(int i = 0; i < splitAllInOne.length; i++) {
			if(splitAllInOne[i].length()> name.length()+1) {
				if(splitAllInOne[i].substring(1, name.length() + 1).equalsIgnoreCase(name)) {
					fineCampi = i;
					//dichiarazioneTrovata = true;
					break;
				}
			}
		}
			
		
		if(!dichiarazioneTrovata) {
			name= splitAllInOne[0].substring(0, splitAllInOne[0].indexOf(">"));
		}
		System.out.println(name);
		System.out.println(inizioCampi);
		System.out.println(fineCampi);
		for(int i = inizioCampi; i < fineCampi; ) {
			i = Campo.campoNewInstance(splitAllInOne, i, fineCampi, campi) ;
		}

		return new Root(name, campi, inizioCampi, (fineCampi-1));
	}

	public int getElementsByTagName(String tagName) {
		int i = 0;

		for(Element campo: campi) {
			i += campo.getElementsByTagName(tagName);
		}

		return i;
	}

	@Override
	public String getTextContent() {
		return null;
	}


	@Override
	public ArrayList<Element> getChildElements() {
		ArrayList<Element> elements = new ArrayList<Element>();

		for(Element c : campi) {
			elements.add(c);
		}

		return elements;


	}

	public String toString() {
		System.out.println("////////// INIZIO ROOOT ///////////////////");
		System.out.println("La root è : " + rootName);
		System.out.println("La root inizia : " + inizioCampi);
		System.out.println("La root finisce : " + fineCampi);
		System.out.println(campi.size());
		System.out.println("Metodo getAttribute: " + getAttribute("version"));

		for(Element element: campi) {
			element.toString();
		}
//
//		System.out.println("Metodo getElementsByTagName: " + getElementsByTagName("risposta"));
//		System.out.println("Metodo getChildElements: " + getChildElements());
//		System.out.println("Metodo getTagName: " + getTagName());
//		System.out.println("Metodo getTextContent: " + getTextContent());
//		ArrayList<Argomento> argomentos = getAttributes();
//		if (argomentos.size() != 0){
//			for( Argomento a : getAttributes()){
//				System.out.println("Metodo getAttributes: " + a.toString());
//			}
//
//		}
//		System.out.println("Metodo getAttribute: " + getAttribute("Value"));
//
//		System.out.println("///////////  FINE ROOT   //////////////////");


		return "";
	}
}
