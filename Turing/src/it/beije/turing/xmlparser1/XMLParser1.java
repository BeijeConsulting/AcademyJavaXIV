package it.beije.turing.xmlparser1;

import java.nio.file.Paths;

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
	}

}
