package it.beije.turing.challenge.rubrica;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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


public class RubricaXML implements Rubrica{
	public static List<Contatto> readRubricaFromFile(Scanner s){
		List<Contatto> ris = new ArrayList<Contatto>();
		String path = null;
		while(path == null) {
			System.out.println("Inserire nome file senza estensione.");
			path = s.nextLine();
			if(path.equalsIgnoreCase("exit")) return null;
			Path filePath = Paths.get("File",path+".xml");
			File file = new File(filePath.toAbsolutePath().toString());
			if(!file.exists()) {
				System.out.println("File inesistente! inserire nuovo file.(scrivere exit per uscire)");
				path = null;
			}
		}
		Path filePath = Paths.get("File",path+".xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		Document document = null;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(filePath.toAbsolutePath().toString());
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
					ris.add(c);
				}
			}

		} catch (ParserConfigurationException pcEx) {
			pcEx.printStackTrace();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} catch (SAXException saxEx) {
			saxEx.printStackTrace();
		}	
		return ris;
	}

	public static List<Contatto> writeRubricaOnFile(List<Contatto> allContact, Scanner s) {
		List<Contatto> ris = new ArrayList<Contatto>();
		String path = null;
		while(path == null) {
			System.out.println("Inserire nome file senza estensione.");
			path = s.nextLine();
			if(path.equalsIgnoreCase("exit")) return null;
		}
		Path filePath = Paths.get("File",path+".xml");
		File file = new File(filePath.toAbsolutePath().toString());
		if(file.exists()) {
			System.out.println("File esistente, che fare?\n"
					+ "1: Sovrascrivi File\n"
					+ "2: Scrivi in append");
			String a = s.nextLine();
			switch(a) {
			default:
			case "1":
				break;
			case "2": 
				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder documentBuilder = null;
				Document document = null;
				try {
					documentBuilder = documentBuilderFactory.newDocumentBuilder();
					document = documentBuilder.parse(filePath.toAbsolutePath().toString());
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
							ris.add(c);
						}
					}
				} catch (ParserConfigurationException pcEx) {
					pcEx.printStackTrace();
				} catch (IOException ioEx) {
					ioEx.printStackTrace();
				} catch (SAXException saxEx) {
					saxEx.printStackTrace();
				}
				break;
			}
		}
		for(Contatto c : allContact) {
			ris.add(c);
		}
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		Document doc = documentBuilder.newDocument();
		Element contattiEl = doc.createElement("contatti");
		doc.appendChild(contattiEl);

		for(Contatto c : ris) {
			Element contatto = doc.createElement("contatto");
			contatto.setAttribute("id", Integer.toString(c.getId()));

			Element cognome = doc.createElement("cognome");
			cognome.setTextContent(c.getCognome());
			contatto.appendChild(cognome);

			Element nome = doc.createElement("nome");
			nome.setTextContent(c.getNome());
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

			contattiEl.appendChild(contatto);
		}

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		DOMSource source = new DOMSource(doc);

		StreamResult result = new StreamResult(new File(filePath.toAbsolutePath().toString()));

		try {
			transformer.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}

		return ris;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static List<Element> getChildElements(Element element) {
		List<Element> childElements = new ArrayList<Element>();
		NodeList nodeList = element.getChildNodes();
		for (int n = 0; n < nodeList.getLength(); n++) {
			if (nodeList.item(n) instanceof Element) childElements.add((Element)nodeList.item(n));
		}

		return childElements;
	}
}
