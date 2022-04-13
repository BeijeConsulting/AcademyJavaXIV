package it.beije.turing.rubrica;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ScritturaXML {

	public void getScriviXML(String path, List<Contatto> listaContatto) {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document doc = documentBuilder.newDocument();

			Element contatti = doc.createElement("contatti");
			doc.appendChild(contatti);// root element
			
			{
				Element contatto = doc.createElement("contatto");
				contatto.setAttribute("eta", "25");
				
				Element cognome = doc.createElement("cognome");
				cognome.setTextContent("Marrone");//<cognome>Marrone</cognome>
				contatto.appendChild(cognome);
		
				Element nome = doc.createElement("nome");
				nome.setTextContent("Emma");//<nome>Emma</nome>
				contatto.appendChild(nome);
		
				Element telefono = doc.createElement("telefono");
				telefono.setTextContent("432423");
				contatto.appendChild(telefono);
		
				Element email = doc.createElement("email");
				email.setTextContent("emma@marrone.it");
				contatto.appendChild(email);
		
				Element note = doc.createElement("note");
				note.setTextContent("la nota cantante");
				contatto.appendChild(note);
				
				contatti.appendChild(contatto);
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			
			StreamResult result = new StreamResult(new File(path));
			
			StreamResult syso = new StreamResult(System.out);

			try {
				transformer.transform(source, result);
				transformer.transform(source, syso);
			} catch (TransformerException e) {
				e.printStackTrace();
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}

	}

}
