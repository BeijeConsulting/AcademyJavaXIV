package it.beije.turing.xmlparser1.ConcreteClass;

import java.util.List;
import java.util.ArrayList;

import it.beije.turing.xmlparser1.Interfaces.Documento;
import it.beije.turing.xmlparser1.Interfaces.Elemento;

public class DocumentoConcreto implements Documento {
	private List<String> testoTotale;
	private String path;

	public DocumentoConcreto() {
		super();
		testoTotale = new ArrayList<>();
		path = "";
	}
	
	public List<String> getTestoTotale() {
		return testoTotale;
	}
	
	public void setTestoTotale(List<String> testoTotale) {
		this.testoTotale = testoTotale;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	private String ToStringTestoTotale() {
		String tmp = "";
		for(int i = 1; i < testoTotale.size(); i++) {
			tmp += (testoTotale.get(i) + "\n");
		}
		return tmp;
	}
	
	public Elemento getDocumentElement(){
		String s = ToStringTestoTotale();
		ElementoConcreto e = new ElementoConcreto(s);
		if(testoTotale.size() >= 2) {
			if(testoTotale.size() == 2) {
				
			}
			String tmp = testoTotale.get(1);
			String tmp2 = testoTotale.get(testoTotale.size()-1);
			try {
				if(tmp == null) {
					throw new Exception("Formato riga 1 errato, null");
				}
				if(tmp2 == null) {
					throw new Exception("Formato ultima riga errato, null");
				}
				if(tmp.charAt(0) != '<' || tmp.charAt(tmp.length()-1) != '>') {
					throw new Exception("Formato riga 1 errato");
				} else if(tmp2.charAt(0) != '<' || tmp2.charAt(tmp2.length()-1) != '>') {
					throw new Exception("Formato ultima riga errato");
				}
				if(!("/"+tmp.substring(1)).equals(tmp2.substring(1))) {
					throw new Exception("TagName root non combacia");
				}
				e.setTagName(tmp.substring(1,tmp.length()-1));
				for(int i = 2; i < testoTotale.size()-1; i++) {
					e.setTextContent(e.getTextContent().concat(testoTotale.get(i)+"\n"));
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
		return e;
	}
	
}
