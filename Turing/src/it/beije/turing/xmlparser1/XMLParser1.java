package it.beije.turing.xmlparser1;

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
		Documento test = DocumentoBuilder.parse(Paths.get("File", "Challenge", "rub.xml").toAbsolutePath().toString());
		Elemento root = test.getDocumentElement();
		
		System.out.println(root.getTestoCompleto());
		System.out.println("TagName: " + root.getTagName());
		System.out.println("Text Content: " + root.getTextContent());
		List<Elemento> lE = root.getElementsByTagName("contatto",new ArrayList<Elemento>(),0);
		System.out.println(lE.size());
		for(int i = 0; i < lE.size(); i++) {
			System.out.println(lE.get(i).getTagName());
			System.out.println(lE.get(i).getTestoCompleto());
			System.out.println(lE.get(i).getTextContent());
		}
	}

}
