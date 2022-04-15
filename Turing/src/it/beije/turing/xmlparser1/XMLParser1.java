package it.beije.turing.xmlparser1;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import it.beije.turing.xmlparser1.ConcreteClass.DocumentoBuilder;
import it.beije.turing.xmlparser1.Interfaces.Documento;
import it.beije.turing.xmlparser1.Interfaces.Elemento;

/**
 * 
 * @author Cognome Nome, Cognome Nome
 *
 */
public class XMLParser1 {

	public static void main(String[] args) {
		Documento test = null;
		test = DocumentoBuilder.parse(Paths.get("File", "Challenge", "rub"
					+ ".xml").toAbsolutePath().toString());
		
		Elemento root = test.getDocumentElement();
		if(root == null) {
			return;
		}
		
		
		System.out.println(root.getTestoCompleto());
		System.out.println("TagName: " + root.getTagName());
		System.out.println("Text Content: " + root.getTextContent());
		System.out.println("id = "+root.getAttribute("id"));
		System.out.println("eta = "+root.getAttribute("eta"));
		//System.out.println(root.getElementsByTagName("contatto",new ArrayList<Elemento>(),0));
		System.out.println(root.getChildElements());
		System.out.println(root.getChildElements().size());
		System.out.println(root.getChildNodes());
		System.out.println(root.getChildNodes().size());
		System.out.println(root.getAttributes());
		List<Elemento> lE = root.getElementsByTagName("contatto",new ArrayList<Elemento>(),0);
		Elemento el = null;
		System.out.println("Numero properties: " + lE.size());
		for(int i = 0; i < lE.size(); i++) {
			el = lE.get(0);
			System.out.println(lE.get(i).getTagName());
			System.out.println(lE.get(i).getTestoCompleto());
			System.out.println(lE.get(i).getTextContent());
			System.out.println(lE.get(i).getAttributes());
			System.out.println(lE.get(i).getAttribute("value"));
		}
		/*
		List<Elemento> lE2 = el.getElementsByTagName("risposta",new ArrayList<Elemento>(),0);
		System.out.println("Numero property: " + lE2.size());
		for(int i = 0; i < lE2.size(); i++) {
			System.out.println(lE2.get(i).getTagName());
			System.out.println(lE2.get(i).getTestoCompleto());
			System.out.println(lE2.get(i).getTextContent());
			System.out.println(lE2.get(i).getAttribute("name"));
			System.out.println(lE2.get(i).getAttribute("value"));
		}
		*/
	}

}
