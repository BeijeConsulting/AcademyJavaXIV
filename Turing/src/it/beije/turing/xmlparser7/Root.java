package it.beije.turing.xmlparser7;

import java.util.ArrayList;

public class Root {

	private String rootName;
	private ArrayList<Campo> campi;
	private Integer inizioCampi;
	private Integer fineCampi;

	public Root(String rootName, ArrayList<Campo> campi, Integer inizioCampi, Integer fineCampi) {
		this.rootName = rootName;
		this.campi = campi;
		this.inizioCampi = inizioCampi;
		this.fineCampi = fineCampi;
	}

	public String getRootName() {
		return rootName;
	}

	public void setRootName(String root) {
		this.rootName = root;
	}

	public ArrayList<Campo> getCampi() {
		return campi;
	}

	public void setCampi(ArrayList<Campo> campi) {
		this.campi = campi;
	}
	
	public Root creaInstanzaRoot(String[] splitAllInOne) {
		boolean dichiarazioneTrovata = false;
		int campi = 0;
		int fineCampi = 0;
		String name = "";
		
		for(int i = 0; i < splitAllInOne.length; i++) {
			if(splitAllInOne[i].substring(0, "?>".length()).equalsIgnoreCase("?>")) {
				name = splitAllInOne[i + 1].substring(0, splitAllInOne[i + 1].indexOf(">"));
				inizioCampi = i +2;
				dichiarazioneTrovata = true;
				break;
			}
		}
		
		for(int i = 0; i < splitAllInOne.length; i++) {
			if(splitAllInOne[i].substring(1, name.length() + 1).equalsIgnoreCase(name)) {
				fineCampi = i;
				break;
			}
		}
		
		if(!dichiarazioneTrovata) {
			rootName = splitAllInOne[0].substring(0, splitAllInOne[0].indexOf(">"));
		}
		
		return new Root(name, null, campi, fineCampi);
	}

}
