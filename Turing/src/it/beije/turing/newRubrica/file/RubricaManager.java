package it.beije.turing.newRubrica.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

import it.beije.turing.newRubrica.rubrica.Contatto;

public class RubricaManager {
	///////////////////////////////////////CSV///////////////////////////////////////////////
	public List<Contatto> loadRubricaFromCSV(String pathFile, String separator) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		List<Contatto> contatti = null;
		try {
			fileReader = new FileReader(pathFile);
			
			bufferedReader = new BufferedReader(fileReader);
			int c = 0;
			contatti = new ArrayList<Contatto>();
			Contatto contatto = null;
			while (bufferedReader.ready()) {
				String row = bufferedReader.readLine();
				String[] columns = row.split(separator);
				contatto = new Contatto();
				try {
					contatto.setCognome(columns[0]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setCognome("");
				}
				try {
					contatto.setNome(columns[1]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setNome("");
				}
				try {
					contatto.setEmail(columns[2]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setEmail("");
				}
				try {
					contatto.setTelefono(columns[3]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setTelefono("");
				}
				try {
					contatto.setNote(columns[4]);
				}catch(ArrayIndexOutOfBoundsException e) {
					contatto.setNote("");
				}
				eliminaVirgolette(contatto);
				contatti.add(contatto);
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
		
		System.out.println("contatti: " + contatti.size());
		return contatti;
	}
	
	public void writeRubricaCSV(List<Contatto> contatti, String pathFile, String separator) {
		File file = new File(pathFile);
		System.out.println("file exists? " + file.exists());
		
		if (file.exists()) {
			System.out.println("FILE GIA' ESISTENTE!!!");
		}
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);

			for (Contatto contatto : contatti) {
				fileWriter.write(contatto.getCognome());
				fileWriter.write(separator);
				fileWriter.write(contatto.getNome());
				fileWriter.write(separator);
				fileWriter.write(contatto.getEmail());
				fileWriter.write(separator);
				fileWriter.write(contatto.getTelefono());
				fileWriter.write(separator);
				fileWriter.write(contatto.getNote());
				fileWriter.write(separator);
			}
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException fEx) {
				fEx.printStackTrace();
			}
			
			System.out.println("done");
		}
	}
	
	////////////////////////////////////////XML//////////////////////////////////////////////
	public List<Contatto> loadRubricaFromXML(String pathFile) {
		List<Contatto> ris = new ArrayList<>();
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		Document document = null;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(pathFile);
			
			Element root = document.getDocumentElement();
			//System.out.println("root : " + root.getTagName());
			NodeList nodes = root.getChildNodes();
			//System.out.println("nodes num : " + nodes.getLength());
			
			List<Element> children = getChildElements(root);
			System.out.println("children num : " + children.size());
			
			for (Element el : children) {
				if (el.getTagName().equalsIgnoreCase("contatto")) {
					List<Element> contatto = getChildElements(el);
					Contatto c = new Contatto();
					for (Element value : contatto) {
						switch (value.getTagName().toLowerCase()) {
						case "nome":
							//System.out.println("nome : " + value.getTextContent());
							c.setNome(value.getTextContent());
							break;
						case "cognome":
							//System.out.println("cognome : " + value.getTextContent());
							c.setCognome(value.getTextContent());
							break;
						case "telefono":
							//System.out.println("telefono : " + value.getTextContent());	
							c.setTelefono(value.getTextContent());
							break;
						case "email":
							//System.out.println("email : " + value.getTextContent());
							c.setEmail(value.getTextContent());
							break;
						case "note":
							//System.out.println("note : " + value.getTextContent());	
							c.setNote(value.getTextContent());
							break;

						default:
							break;
						}
						
					}
					
					//System.out.println("eta' : " + el.getAttribute("eta"));
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
		System.out.println("Done!");
		return ris;
	}
	public void writeRubricaXML(List<Contatto> contatti, String pathFile) {
		
	}
	
	///////////////////////////////////////Generale//////////////////////////////////////////
	public static boolean eliminaVirgolette(Contatto c) {
		
		if(c.getNome().startsWith("\"")) {
			c.setNome(c.getNome().substring(1));
		}else if(c.getNome().endsWith("\"")) {
			c.setNome(c.getNome().substring(0,c.getNome().length()-1));
		}else if(c.getNome().startsWith("\"") && c.getNome().endsWith("\"")) {
			c.setNome(c.getNome().substring(1,c.getNome().length()-1));
		}
		if(c.getCognome().startsWith("\"")) {
			c.setCognome(c.getCognome().substring(1));
		}else if(c.getCognome().endsWith("\"")) {
			c.setCognome(c.getCognome().substring(0,c.getCognome().length()-1));
		}else if(c.getCognome().startsWith("\"") && c.getCognome().endsWith("\"")) {
			c.setCognome(c.getCognome().substring(1,c.getCognome().length()-1));
		}
		if(c.getTelefono().startsWith("\"")) {
			c.setTelefono(c.getTelefono().substring(1));
		}else if(c.getTelefono().endsWith("\"")) {
			c.setTelefono(c.getTelefono().substring(0,c.getTelefono().length()-1));
		}else if(c.getTelefono().startsWith("\"") && c.getTelefono().endsWith("\"")) {
			c.setTelefono(c.getTelefono().substring(1,c.getTelefono().length()-1));
		}
		if(c.getEmail().startsWith("\"")) {
			c.setEmail(c.getEmail().substring(1));
		}else if(c.getEmail().endsWith("\"")) {
			c.setEmail(c.getEmail().substring(0,c.getEmail().length()-1));
		}else if(c.getEmail().startsWith("\"") && c.getEmail().endsWith("\"")) {
			c.setEmail(c.getEmail().substring(1,c.getEmail().length()-1));
		}
		return true;
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
