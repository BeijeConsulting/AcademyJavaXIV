package it.beije.turing.rubrica;

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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RubricaXML {

	public static List<Element> getChildElements(Element element) {
		List<Element> childElements = new ArrayList<Element>();
		NodeList nodeList = element.getChildNodes();
		for (int n = 0; n < nodeList.getLength(); n++) {
			if (nodeList.item(n) instanceof Element)
				childElements.add((Element) nodeList.item(n));
		}

		return childElements;
	}

	public static List <Contatto> readXML(String path) {
		List<Contatto> contatti = new ArrayList<>();
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		Document document = null;

		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(path);

			Element root = document.getDocumentElement();
			System.out.println("root : " + root.getTagName());

			NodeList nodes = root.getChildNodes();
			System.out.println("nodes num : " + nodes.getLength());

			List<Element> children = getChildElements(root);
			System.out.println("children num : " + children.size());
			for (Element el : children) {
				Contatto c = new Contatto();
				if (el.getTagName().equalsIgnoreCase("id")) {
					List<Element> contatto = getChildElements(el);
					
					for (Element value : contatto) {
						
						switch (value.getTagName().toLowerCase()) {
						case "nome":
							c.setNome( value.getTextContent());
							System.out.println("nome : " + value.getTextContent());
							break;
						case "cognome":
							c.setCognome( value.getTextContent());
							System.out.println("cognome : " + value.getTextContent());
							break;
						case "telefono":
							c.setTelefono( value.getTextContent());
							System.out.println("telefono : " + value.getTextContent());
							break;
						case "email":
							c.setEmail( value.getTextContent());
							System.out.println("email : " + value.getTextContent());
							break;
						case "note":
							c.setNote( value.getTextContent());
							System.out.println("note : " + value.getTextContent());
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

	public static void writeXML(List<Contatto> contatti, String path) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			Document doc = documentBuilder.newDocument();
			Element el = doc.createElement("contatto");
			doc.appendChild(el);

			for (Contatto c : contatti) {

				Element id = doc.createElement("id");
				id.setAttribute("id", "" + c.getId());
				el.appendChild(id);
				
				Element cognome = doc.createElement("cognome");
				cognome.setTextContent("" + c.getCognome());
				id.appendChild(cognome);

				Element nome = doc.createElement("nome");
				nome.setTextContent("" + c.getNome());
				id.appendChild(nome);

				Element telefono = doc.createElement("telefono");
				telefono.setTextContent("" + c.getTelefono());
				id.appendChild(telefono);

				Element email = doc.createElement("email");
				email.setTextContent("" + c.getEmail());
				id.appendChild(email);

				Element note = doc.createElement("note");
				note.setTextContent("" + c.getNote());
				id.appendChild(note);

				el.appendChild(id);
			}
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);

				StreamResult result = new StreamResult(new File(path));

				 //Output to console for testing
				StreamResult syso = new StreamResult(System.out);

				transformer.transform(source, result);
				transformer.transform(source, syso);
		
		}catch(Exception e) {
			e.printStackTrace();
		}

		

	}

}
