package it.beije.turing.xmlparser7;

import java.util.ArrayList;

public class Documento {

	private String xmlDichiarazione;
	private String root;
	private ArrayList<Campo> campi;
	
	public String getXmlDichiarazione() {
		return xmlDichiarazione;
	}

	public void setXmlDichiarazione(String xmlDichiarazione) {
		this.xmlDichiarazione = xmlDichiarazione;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public ArrayList<Campo> getCampi() {
		return campi;
	}

	public void setCampi(ArrayList<Campo> campi) {
		this.campi = campi;
	}

	
	public boolean isXmlDichiarazione(String s) {
		if(s.contentEquals("<?xml")) {
			setXmlDichiarazione(s);
			return true;
		}
		
		return false;
	}
	
	public void 
}
