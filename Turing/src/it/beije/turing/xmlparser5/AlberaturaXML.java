package it.beije.turing.xmlparser5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class AlberaturaXML {
	
	private String path = "";
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

//  getPrimaRiga();
//	getRootElement() //torna l'elemento root
//	getChildNodes() //torna tutti i nodi "figli" interni all'elemento su cui viene eseguito
//	getChildElements() //torna i soli elementi figli dell'elemento su cui viene eseguito
//	getElementsByTagName(String tagName) //torna TUTTI gli elementi con quello specifico nome
//	getTagName() //torna il nome del tag
//	getTextContent() //torna il contenuto del tag
//	getAttributes() //torna l'elenco degli attributi dell'elemento
//	getAttribute(String attribute) //torna il valore dell'attributo specificato

//	<?xml version="1.0" encoding="UTF-8" standalone="no"?>
//	<contatti>
//		<contatto>
//			<nome>Pippo</nome>
//			<cognome>Pluto</cognome>
//			<telefono>3331234567</telefono>
//			<email>pippo@pluto.net</email>
//		</contatto>
//		<contatto>
//			<nome>Paolino</nome>
//			<cognome>Paperino</cognome>
//			<telefono>00423803243423</telefono>
//		</contatto>
//	</contatti>



	// se è presenta la riga di dichiarazione xml la elimina e restituisce il contenuto del file senza la prima riga,
	// altrimenti restituisce il contenuto senza nesusna modifica
	public String getRootElement() {
		String s = this.getContenutoFile();
		String senzaIntestazione = null;
		if(s.startsWith("<?") && s.contains("?>")) {
//			String intestazione = s.subSequence(s.indexOf("<?"), s.indexOf("?>") + 2) +"";
//			System.out.println(intestazione);
			senzaIntestazione = s.substring(s.indexOf("?>") + 2);
			//System.out.println(senzaIntestazione);
//			if(senzaIntestazione.contains("<") || senzaIntestazione.contains(">")) {
//				return "XML formattato male";
//			}
		}
		if(senzaIntestazione != null) {
			return senzaIntestazione;
		}
		return s;
		
	}

	public String getContenutoFile() {
		StringBuilder s = new StringBuilder();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(this.path);
			br = new BufferedReader(fr);

			while (br.ready()) {
				s.append((char) br.read());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		//System.out.println(s.toString());
		return s.toString();
	}
	
	public List<String> getChildElements(String el) {
		List<String> children = new ArrayList<>();
		int indexBegin = getIndexOfChild(el, "<");
		int indexEnd = el.lastIndexOf("<");
		String textContent = el.substring(indexBegin, indexEnd);
		String tagName = getTagName(textContent);
		
		
		
		while (textContent.contains(tagName)) {
			String closureTag = "/" + tagName + ">";
			indexBegin = textContent.indexOf("<");
			int startClosure = textContent.indexOf(closureTag);
			int endClosure = startClosure + closureTag.length();
			
			String child = textContent.substring(indexBegin, endClosure);
			
			int cutContentFrom = textContent.indexOf("<", startClosure);
			if (cutContentFrom != -1) {
				textContent = textContent.substring(cutContentFrom);
				tagName = getTagName(textContent);
			} else {
				textContent = "";
			}
				
			children.add(child);
		}
		
		
		return children;
	}
	
	public String getTagName(String el) {
		String tagName = new String();
		int firstSpacebar = el.indexOf(" ");
		int closingTag = el.indexOf(">");
		if (firstSpacebar == -1) {
			tagName = el.substring(1, closingTag);
		} else if(firstSpacebar > closingTag){
			tagName = el.substring(1, closingTag);
		} else {
			tagName = el.substring(1, firstSpacebar);
		}
		
		return tagName;
	}
	
	public int getIndexOfChild(String el, String c) {
		int index = el.indexOf(c, el.indexOf(">"));
		return index;
	}
	
}
