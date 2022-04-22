package it.beije.turing.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import it.beije.turing.rubrica.Contatto;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLmanager {
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
	
	public static List<Element> getChildElements(Element element) {
		List<Element> childElements = new ArrayList<Element>();
		NodeList nodeList = element.getChildNodes();
		for (int n = 0; n < nodeList.getLength(); n++) {
			if (nodeList.item(n) instanceof Element) childElements.add((Element)nodeList.item(n));
		}
		
		return childElements;
	}

	public static List<Contatto> readXML(String pathXML) {
		List<Contatto> contatti= new ArrayList<>();
		Contatto cont=null;
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		Document document = null;
		
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(pathXML);
			
			Element root = document.getDocumentElement();

			NodeList nodes = root.getChildNodes();

			List<Element> children = getChildElements(root);


			for (Element el : children) {
				if (el.getTagName().equalsIgnoreCase("contatto")) {
					List<Element> contatto = getChildElements(el);
					cont= new Contatto();
					for (Element value : contatto) {

						switch (value.getTagName().toLowerCase()) {
						case "nome":
							cont.setNome(value.getTextContent());
							break;
						case "cognome":
							cont.setCognome(value.getTextContent());
							break;
						case "telefono":
							cont.setTelefono(value.getTextContent());
							break;
						case "email":
							cont.setEmail(value.getTextContent());
							break;
						case "note":
							cont.setNote(value.getTextContent());
							break;}

					}
					contatti.add(cont);
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
	
	public static void writeXML(List<Contatto> contatList) throws Exception {
		System.out.println("entro");
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
		Document doc = documentBuilder.newDocument();

		Element contatti = doc.createElement("contatti");
		doc.appendChild(contatti);//root element
		for (Contatto c: contatList){
			Element contatto = doc.createElement("contatto");

			Element cognome = doc.createElement("cognome");
			cognome.setTextContent(c.getCognome());//<cognome>Marrone</cognome>
			contatto.appendChild(cognome);
	
			Element nome = doc.createElement("nome");
			nome.setTextContent(c.getNome());//<nome>Emma</nome>
			contatto.appendChild(nome);
	
			Element telefono = doc.createElement("telefono");
			telefono.setTextContent(c.getTelefono());
			contatto.appendChild(telefono);
	
			Element email = doc.createElement("email");
			email.setTextContent(c.getEmail());
			contatto.appendChild(email);
	
			Element note = doc.createElement("note");
			note.setTextContent(c.getNote());
			contatto.appendChild(note);
			
			contatti.appendChild(contatto);
		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		
		StreamResult result = new StreamResult(new File("C:\\Users\\39346\\IdeaProjects\\AcademyJavaXIV\\Turing\\src\\it\\beije\\turing\\rubrica\\dbToXml.xml"));

		// Output to console for testing
		StreamResult syso = new StreamResult(System.out);

		transformer.transform(source, result);
		transformer.transform(source, syso);

		System.out.println("File salvato");

	}

}
