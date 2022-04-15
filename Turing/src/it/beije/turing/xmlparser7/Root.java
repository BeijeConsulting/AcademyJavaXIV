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
	
	public static Root creaInstanzaRoot(String[] splitAllInOne) {
		boolean dichiarazioneTrovata = false;
		int inizioCampi = 0;
		int fineCampi = 0;
		String name = "";
		ArrayList<Campo> campi = new ArrayList<>();
		
		
		// cercando l'inizio splitAllInOne[i].indexOf("?>")
		for(int i = 0; i < splitAllInOne.length; i++) {
			if(splitAllInOne[i].length()> 0 && splitAllInOne[i].indexOf("?>") != -1) {
				if(splitAllInOne[i].substring(splitAllInOne[i].indexOf("?>"),splitAllInOne[i].indexOf("?>")+ "?>".length()).equalsIgnoreCase("?>")) {
					name = splitAllInOne[i + 1].substring(0, splitAllInOne[i + 1].indexOf(">"));
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
		for(Campo c: campi) {
			c.toString();
		}
		return new Root(name, campi, inizioCampi, (fineCampi-1));
	}


	

}
