package it.beije.turing.rubrica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LetturaXML {
	
	/*
	<?xml version="1.0" encoding="UTF-8"?>
	<rubrica>
	    <contatto eta="30">
			<nome>Mario</nome>
			<cognome>Rossi</cognome>
			<telefono>3337658390</telefono>
			<email>mario.rossi@tim.it</email>
			<note>compagno di squadra</note>
		</contatto>
		<contatto eta="35">
			<nome>Claudio</nome>
			<cognome>Bianchi</cognome>
			<telefono>3352672537</telefono>
			<email>claudio.white@virgilio.it</email>
		</contatto>
	</rubrica>
	*/
	
	public List<Contatto> getLetturaXML(String path , List<Contatto> listaContatti){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		Document doc = null;
		try {
			db = dbf.newDocumentBuilder();
			doc = db.parse(path);
			
			Element root = doc.getDocumentElement();
			NodeList nodes = root.getChildNodes();
			List<Element> children = getChildElements(root);
			
			for (Element el : children) {
				if (el.getTagName().equalsIgnoreCase("contatto")) {
					List<Element> contatto = getChildElements(el);
					for (Element value : contatto) {
						Contatto c = new Contatto();
						switch (value.getTagName().toLowerCase()) {
						case "nome": c.setNome(value.getTextContent());
							break;
						case "cognome": c.setCognome(value.getTextContent());					
							break;
						case "telefono": c.setTelefono(value.getTextContent());				
							break;
						case "email": c.setEmail(value.getTextContent());					
							break;
						case "note": c.setNote(value.getTextContent());			
							break;

						default:
							break;
						}
						listaContatti.add(c);
						
					}
					
					System.out.println("eta' : " + el.getAttribute("eta"));
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return listaContatti;
	}
	
	public static List<Element> getChildElements(Element element) {
		List<Element> childElements = new ArrayList<Element>();
		NodeList nodeList = element.getChildNodes();
		for (int n = 0; n < nodeList.getLength(); n++) {
			if (nodeList.item(n) instanceof Element) childElements.add((Element)nodeList.item(n));
		}
		
		return childElements;
	}
	
		
}
