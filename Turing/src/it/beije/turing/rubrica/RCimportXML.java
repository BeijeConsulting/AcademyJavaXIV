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

public class RCimportXML {
	
	public static List<Element> getChildElements(Element element) {
		List<Element> childElements = new ArrayList<Element>();
		NodeList nodeList = element.getChildNodes();
		for (int n = 0; n < nodeList.getLength(); n++) {
			if (nodeList.item(n) instanceof Element) childElements.add((Element)nodeList.item(n));
		}
		return childElements;
	}

	public static ArrayList<Contatto> getXMLContacts(String xmlPath) {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		Document document = null;
		ArrayList<Contatto> contatti = new ArrayList<>();

		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(xmlPath);

			Element root = document.getDocumentElement();			
			List<Element> children = getChildElements(root);

			for (Element el : children) {
				if (el.getTagName().equalsIgnoreCase("contatto")) {
					List<Element> contatto = getChildElements(el);
					Contatto c = new Contatto();
					for (Element value : contatto) {

						switch (value.getTagName().toLowerCase()) {
						case "nome":
							c.setNome(value.getTextContent());
							break;
						case "cognome":
							c.setCognome(value.getTextContent());						
							break;
						case "telefono":
							c.setTelefono(value.getTextContent());						
							break;
						case "email":
							c.setEmail(value.getTextContent());				
							break;
						case "note":
							c.setNote(value.getTextContent());				
							break;

						default:
							break;
						}
					}
					contatti.add(c);
				}
				
			}
		} catch (ParserConfigurationException pcEx) {
			pcEx.printStackTrace();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} catch (SAXException saxEx) {
			saxEx.printStackTrace();
		}
		return contatti;
	}

}
