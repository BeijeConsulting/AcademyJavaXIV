package it.beije.turing.rubrica;


import java.io.*;
import java.util.*;
import it.beije.turing.file.XMLmanager;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import it.beije.turing.file.CSVutil;

public class Rubrica {
	
	public List<Contatto> loadRubricaFromCSV(
				String pathFile, String separator
			) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		List<Contatto> contacts = null;
		int NOME = -1;
		int COGNOME = -1;
		int TELEFONO = -1;
		int EMAIL = -1;
		int NOTE = -1;
		boolean firstLoop = true;
		
		try {			
			fileReader = new FileReader(pathFile);
			bufferedReader = new BufferedReader(fileReader);
			contacts = new ArrayList<>();
			Contatto contact = null;
			while (bufferedReader.ready()) {
				String row = bufferedReader.readLine();
				if (firstLoop) {
					String[] fields = CSVutil.cleanRow(row, separator);
					for (int i = 0; i < fields.length; i++) {
						switch (fields[i].toUpperCase()) {
						case "NOME": {
							NOME = i;
							break;
						}
						case "COGNOME": {
							COGNOME = i;
							break;
						}
						case "TELEFONO": {
							TELEFONO = i;
							break;
						}
						case "EMAIL": {
							EMAIL = i;
							break;
						}
						case "NOTE": {
							NOTE = i;
							break;
						}
						default:
							throw new IllegalArgumentException(
									"Unexpected value: " + fields[i].toUpperCase());
						}
					}
					firstLoop = false;
				} else {
//					System.out.println(row);
					String[] fields = CSVutil.cleanRow(row, separator);
						
					contact = new Contatto();
					if (NOME != -1) {
					contact.setNome(fields[NOME]);
					}
					if (COGNOME != -1) {
					contact.setCognome(fields[COGNOME]);
					}
					if (TELEFONO != -1) {
					contact.setTelefono(fields[TELEFONO]);
					}
					if (EMAIL != -1) {
					contact.setEmail(fields[EMAIL]);
					}
					if (NOTE != -1) {
						contact.setNote(fields[NOTE]);
					}
//					System.out.println(contact);
					contacts.add(contact);
				}
				
			}
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
				fileReader.close();
			} catch (IOException fEx) {
				fEx.printStackTrace();
			}
		}
		
		return contacts;
	
	}
	
	public List<Contatto> loadRubricaFromXML(String pathFile) {
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		Document document = null;
		List<Contatto> contacts = null;
		
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(pathFile);
			contacts = new ArrayList<>();
			
			Element root = document.getDocumentElement();
			
			List<Element> children = XMLmanager.getChildElements(root);
			
			for (Element el : children) {
				if (el.getTagName().equalsIgnoreCase("contatto")) {
					Contatto contact = new Contatto();
					List<Element> contatto = XMLmanager.getChildElements(el);
					for (Element field : contatto) {
						switch (field.getTagName().toLowerCase()) {
						case "cognome": {
							contact.setCognome(field.getTextContent());
							break;
						}
						case "nome": {
							contact.setNome(field.getTextContent());
							break;
						}
						case "telefono": {
							contact.setTelefono(field.getTextContent());
							break;
						}
						case "email": {
							contact.setEmail(field.getTextContent());
							break;
						}
						case "note": {
							contact.setNote(field.getTextContent());
							break;
						}
						default:
							throw new IllegalArgumentException("Unexpected value: " + field.getTagName().toLowerCase());
						}
					}
					
					contacts.add(contact);
				}
			}
			
		} catch (ParserConfigurationException pcEx) {
			pcEx.printStackTrace();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} catch (SAXException saxEx) {
			saxEx.printStackTrace();
		}
		
		return contacts;
	}	
	
	public void writeRubricaCSV(
				List<Contatto> contacts, String pathFile,
				String separator) {
		File file = new File(pathFile);
		FileWriter fileWriter = null;
		
		try {
			fileWriter = new FileWriter(file);
			for (Contatto contact : contacts) {
				if (contact.getCognome() != null) {
					fileWriter.write(contact.getCognome());
				}
				fileWriter.write('\t');
				if (contact.getNome() != null) {
					fileWriter.write(contact.getNome());
				}
				fileWriter.write('\t');
				if (contact.getEmail() != null) {
					fileWriter.write(contact.getEmail());
				}
				fileWriter.write('\t');
				if (contact.getTelefono() != null) {
					fileWriter.write(contact.getTelefono());
				}
				fileWriter.write('\n');
			}
		} catch (IOException ioE) {
			ioE.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException fEx) {
				fEx.printStackTrace();
			}
			
			System.out.println("Done");
		}
	}
	
	public void writeRubricaXML(
			List<Contatto> contacts, String pathFile) {
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		try {
			
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document doc = documentBuilder.newDocument();
			
			Element wrapper = doc.createElement("rubrica");
			doc.appendChild(wrapper);
			
			for (Contatto contact : contacts) {
				Element el = doc.createElement("contatto");
				
				if (contact.getCognome() != null) {
					Element cognome = doc.createElement("cognome");
					cognome.setTextContent(contact.getCognome());
					el.appendChild(cognome);
				}
				if (contact.getNome() != null) {
					Element nome = doc.createElement("nome");
					nome.setTextContent(contact.getNome());
					el.appendChild(nome);
				}
				if (contact.getEmail() != null) {
					Element email = doc.createElement("email");
					email.setTextContent(contact.getEmail());
					el.appendChild(email);
				}
				if (contact.getTelefono() != null) {
					Element telefono = doc.createElement("telefono");
					telefono.setTextContent(contact.getTelefono());
					el.appendChild(telefono);
				}
				if (contact.getNote() != null) {
					Element note = doc.createElement("note");
					note.setTextContent(contact.getNote());
					el.appendChild(note);
				}
				
				wrapper.appendChild(el);
				
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				
				StreamResult result = new StreamResult(new File(pathFile));
				
				StreamResult syso = new StreamResult(System.out);
				
				transformer.transform(source, result);
				transformer.transform(source, syso);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Rubrica rubrica = new Rubrica();
		List<Contatto> contacts =
				rubrica.loadRubricaFromCSV("/temp/rubrica.csv", ";");
		rubrica.writeRubricaCSV(
				contacts, "/temp/NewRubricaCSV.csv", ";");
		
		List<Contatto> contactsXML =
				rubrica.loadRubricaFromXML("/temp/NewRubricaXML.xml");
		
		rubrica.writeRubricaXML(contacts, "/temp/NewRubricaXML.xml");
		rubrica.writeRubricaXML(contactsXML, "/temp/NewRubricaXML2.xml");
	}
}
