package it.beije.turing.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import it.beije.turing.rubrica.Contatto;

public class XMLmanager {

	public static List<Element> getChildElements(Element element) {
		List<Element> childElements = new ArrayList<Element>();
		NodeList nodeList = element.getChildNodes();
		for (int n = 0; n < nodeList.getLength(); n++) {
			if (nodeList.item(n) instanceof Element) childElements.add((Element)nodeList.item(n));
		}
		
		return childElements;
	}
	
	public static List<Contatto> loadRubricaFromXML(String path) throws ParserConfigurationException, IOException, SAXException {
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		Document document = null;
		
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(path);
			
			Element root = document.getDocumentElement();			
			List<Element> children = getChildElements(root);
			
			for (Element el : children) {
				Contatto contatto = new Contatto();
				if (el.getTagName().equalsIgnoreCase("contatto")) {
					List<Element> elmContatto = getChildElements(el);
					for (Element elm : elmContatto) {
						switch (elm.getTagName().toLowerCase()) {
							case "nome":
								contatto.setNome(elm.getTextContent());
								break;
							case "cognome":
								contatto.setCognome(elm.getTextContent());						
								break;
							case "telefono":
								contatto.setTelefono(elm.getTextContent());				
								break;
							case "email":
								contatto.setEmail(elm.getTextContent());						
								break;
							case "note":
								contatto.setNote(elm.getTextContent());					
								break;
						}
						
					}
				}
				contatti.add(contatto);
			}
			
		} catch (ParserConfigurationException pcEx) {
			pcEx.printStackTrace();
			throw pcEx;
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} catch (SAXException saxEx) {
			saxEx.printStackTrace();
			throw saxEx;
		}
		
		return contatti;
	}
	
	public static void writeRubricaXML(List<Contatto> contatti, String path) {
		
		try {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
		Document doc = documentBuilder.newDocument();

		Element elementContatti = doc.createElement("contatti");
		doc.appendChild(elementContatti);//root element
		
		for(Contatto contatto : contatti) {
			Element elmContatto = doc.createElement("contatto");
			
			Element nome = doc.createElement("nome");
			nome.setTextContent(contatto.getNome());
			elmContatto.appendChild(nome);
			
			Element cognome = doc.createElement("cognome");
			cognome.setTextContent(contatto.getCognome());
			elmContatto.appendChild(cognome);
			
			Element telefono = doc.createElement("telefono");
			telefono.setTextContent(contatto.getTelefono());
			elmContatto.appendChild(telefono);
			
			Element email = doc.createElement("email");
			email.setTextContent(contatto.getEmail());
			elmContatto.appendChild(email);
			
			Element note = doc.createElement("note");
			note.setTextContent(contatto.getNote());
			elmContatto.appendChild(note);
			
			elementContatti.appendChild(elmContatto);
		}

		//System.out.println("contatti : " + elementContatti.getElementsByTagName("contatto").getLength());
		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		
		StreamResult result = new StreamResult(new File(path));

		// Output to console for testing
		//StreamResult syso = new StreamResult(System.out);

		transformer.transform(source, result);
		//transformer.transform(source, syso);
		} catch(TransformerConfigurationException tcEx) {
			tcEx.printStackTrace();
		} catch(ParserConfigurationException pcEx) {
			pcEx.printStackTrace();
		} catch(TransformerException tEx) {
			tEx.printStackTrace();
		}

		//System.out.println("File saved!");

	}
	
}
