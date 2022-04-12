package it.beije.turing.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import it.beije.turing.rubrica.Contatto;

public class RubricaXML {
	
	public static void writeXML(ArrayList<Contatto> contatti, String path)throws Exception {
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
		Document doc = documentBuilder.newDocument();
		Element el = doc.createElement("contatto");
		doc.appendChild(el);
		
		
		for(Contatto c : contatti) {
			
			
			Element cognome = doc.createElement("cognome");
			cognome.setAttribute("cognome", c.getCognome());
			el.appendChild(cognome);
			
			
			Element nome = doc.createElement("nome");
			nome.setTextContent(c.getNome());
			cognome.appendChild(nome);
			
			Element telefono = doc.createElement("telefono");
			telefono.setTextContent(c.getTelefono());
			cognome.appendChild(telefono);

			Element email = doc.createElement("email");
			email.setTextContent(c.getEmail());
			cognome.appendChild(email);

			Element note = doc.createElement("note");
			note.setTextContent(c.getNote());
			cognome.appendChild(note);
			
			el.appendChild(cognome);
			
			

		}
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);

		StreamResult result = new StreamResult(new File(path.replace(".csv", ".xml")));

		// Output to console for testing
		StreamResult syso = new StreamResult(System.out);

		transformer.transform(source, result);
		transformer.transform(source, syso);
		
	}
	
	
}
