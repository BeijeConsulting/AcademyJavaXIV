package it.beije.turing.xmlparser5;

import java.util.ArrayList;
import java.util.List;

public class AlberaturaXML {
	
//  getPrimaRiga();
//	getRootElement() //torna l'elemento root
//	getChildNodes() //torna tutti i nodi "figli" interni all'elemento su cui viene eseguito
//	getChildElements() //torna i soli elementi figli dell'elemento su cui viene eseguito
//	getElementsByTagName(String tagName) //torna TUTTI gli elementi con quello specifico nome
//	getTagName() //torna il nome del tag
//	getTextContent() //torna il contenuto del tag
//	getAttributes() //torna l'elenco degli attributi dell'elemento
//	getAttribute(String attribute) //torna il valore dell'attributo specificato
	
	public List<String> getChildElements(String el) {
		List<String> children = new ArrayList<>();
		int indexBegin = el.indexOf('>') + 1;
		int indexEnd = el.lastIndexOf('<');
		String textContent = el.substring(indexBegin, indexEnd);
		String tagName = null;
		int firstSpacebar = textContent.indexOf(" ");
		int closingTag = textContent.indexOf(">");
		
		if ((firstSpacebar != -1) && (closingTag < firstSpacebar)) {
			tagName = textContent.substring(1, closingTag);
		} else {
			tagName = textContent.substring(1, firstSpacebar);
		}
		
		while (textContent.contains(tagName)) {
			String closureTag = "/" + tagName + ">";
			int occurrenceOfClosure = textContent.indexOf(closureTag);
			int endOfClosure = occurrenceOfClosure + closureTag.length() - 1;
			
			String child = textContent.substring(0, endOfClosure);
			
			textContent = textContent.substring(endOfClosure);
			
			children.add(child);
		}
		
		
		return children;
	}
	
}
