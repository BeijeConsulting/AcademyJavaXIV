package it.beije.turing.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

public class RubricaController {
	
	public static List<Contatto> loadRubricaFromCSV(String path, String separatore, boolean virgolette) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		List<Contatto> contatti = null;
		
		try {
			
			fileReader = new FileReader(path);
			bufferedReader = new BufferedReader(fileReader);
			contatti = new ArrayList<Contatto>();
			Contatto contatto = null;
			int c = 0;
			int nome = -1, cognome = -1, telefono = -1, email = -1, note = -1;
			
			while (bufferedReader.ready()) {
				String row = bufferedReader.readLine();
				
				String[] columns = null;
				if(virgolette) {
					row = row.substring(1, row.length()-1);
					columns = row.split("\"" +separatore+ "\"");
				} else {					
					columns = row.split(separatore);
				}
				
				if (c == 0) {
					int i = 0;
					for(String s : columns) {
						switch(s) {
							case "NOME":
								nome = i;
								break;
							case "COGNOME":
								cognome = i;
								break;
							case "TELEFONO":
								telefono = i;
								break;
							case "EMAIL":
								email = i;
								break;
							case "NOTE":
								note = i;
								break;
						}
					}
				} else {
					contatto = new Contatto();
					if(columns.length > 0) {
						if(nome != -1) {
							contatto.setNome(columns[nome]);
						}
						if(cognome != -1) {
							contatto.setCognome(columns[cognome]);		
						}
						if(telefono != -1) {
							contatto.setTelefono(columns[telefono]);
						}
						if(email != -1) {
							contatto.setEmail(columns[email]);
						}
						if(note != -1) {
							contatto.setNote(columns[note]);
						}
					}

					//System.out.println(contatto);
					contatti.add(contatto);
				}
				c++;
				//System.out.println(c + " " + row);
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
	
	public static void writeRubricaCSV(List<Contatto> contatti, String path, String separatore) {

		File file = new File(path);
		System.out.println("file exists? " + file.exists());
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			int i = 0;
			for (Contatto contatto : contatti) {
				if(i == 0) {
					fileWriter.write("COGNOME;NOME;EMAIL;TELEFONO;NOTE\n");
				} else {					
					if(contatto.getCognome() != null) {					
						fileWriter.write(contatto.getCognome());
					}
					fileWriter.write(separatore);
					if(contatto.getNome() != null) {					
						fileWriter.write(contatto.getNome());
					}
					fileWriter.write(separatore);
					if(contatto.getEmail() != null) {					
						fileWriter.write(contatto.getEmail());
					}
					fileWriter.write(separatore);
					if(contatto.getTelefono() != null) {					
						fileWriter.write(contatto.getTelefono());
					}
					fileWriter.write(separatore);
					if(contatto.getNote() != null) {				
						fileWriter.write(contatto.getNote());
					}	
					fileWriter.write('\n');
				}
				i++;
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

	public static List<Element> getChildElements(Element element) {
		List<Element> childElements = new ArrayList<Element>();
		NodeList nodeList = element.getChildNodes();
		for (int n = 0; n < nodeList.getLength(); n++) {
			if (nodeList.item(n) instanceof Element) childElements.add((Element)nodeList.item(n));
		}
		
		return childElements;
	}
	
	public static List<Contatto> loadRubricaFromXML(String path) {
		List<Contatto> contatti = new ArrayList<Contatto>();
		
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
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} catch (SAXException saxEx) {
			saxEx.printStackTrace();
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

		System.out.println("contatti : " + elementContatti.getElementsByTagName("contatto").getLength());
		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		
		StreamResult result = new StreamResult(new File(path));

		// Output to console for testing
		StreamResult syso = new StreamResult(System.out);

		transformer.transform(source, result);
		transformer.transform(source, syso);
		} catch(TransformerConfigurationException tcEx) {
			tcEx.printStackTrace();
		} catch(ParserConfigurationException pcEx) {
			pcEx.printStackTrace();
		} catch(TransformerException tEx) {
			tEx.printStackTrace();
		}

		//System.out.println("File saved!");

	}
	
	public static List<Contatto> addScanner(String csvPath, String separatore, boolean virgolette, int nContatti) {
		List<Contatto> contatti = RubricaController.loadRubricaFromCSV(csvPath, separatore, virgolette);
		
		Scanner s = new Scanner(System.in);
//		while (!st.equalsIgnoreCase("exit")) {
//			System.out.println(st);
//			st = s.next();
//			
//			//...
//		}
		
		for(int i = 0; i < nContatti; i++) {
			Contatto contatto = new Contatto();
			System.out.print("\nInserisci nome: ");
			contatto.setNome(s.nextLine());
			System.out.print("Inserisci cognome: ");
			contatto.setCognome(s.nextLine());
			System.out.print("Inserisci telefono: ");
			contatto.setTelefono(s.nextLine());
			System.out.print("Inserisci email: ");
			contatto.setEmail(s.nextLine());
			System.out.print("Inserisci note: ");
			contatto.setNote(s.nextLine());
			contatti.add(contatto);
		}
		s.close();
		
		return contatti;
	}
	
	
	public static void main(String[] args) {
		
		//List<Contatto> contatti = RubricaCsvController.readCSV("/Users/lorenzoorru0/Desktop/CSVjava/rubrica.csv", false);
		//System.out.println(contatti);
		//RubricaCsvController.writeCSV(contatti, "/Users/lorenzoorru0/Desktop/CSVjava/rubricaNew.csv");
		//RubricaCsvController.scannerCSV("/Users/lorenzoorru0/Desktop/CSVjava/rubricaNew.csv", false, 1);
		
		System.out.println(RubricaController.loadRubricaFromXML("/Users/lorenzoorru0/Desktop/CSVjava/rubrica.xml"));
		RubricaController.writeRubricaXML(RubricaController.loadRubricaFromXML("/Users/lorenzoorru0/Desktop/CSVjava/rubrica.xml"), "/Users/lorenzoorru0/Desktop/CSVjava/newRubrica.xml");
	}

}
