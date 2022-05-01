package it.beije.turing.rubrica;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.util.ArrayList;

import it.beije.turing.rubrica.*;
import it.beije.turing.file.CSVreader;

public class RCexport {

	static File file = new File("C:/Users/Padawan/Downloads/rubrica2.csv");

	public static void writeCSVfile(List<Contatto> contatti, File file, String separator) {
		FileWriter fileWriter = null;
		ArrayList<Integer> bins = new ArrayList<>();;

		try {
			fileWriter = new FileWriter(file, true);
			if (!file.exists() || file.length()==0){
				fileWriter.write("NOME"+separator+"COGNOME"+separator+"EMAIL"
						+separator+"TELEFONO"+separator+"NOTE\n");
				for (int i=0; i<5;i++) bins.add(i);
			} else {
				bins = RCimportCSV.getCSVBins(file.getAbsolutePath(), separator);
				System.out.println(bins);
			}
			int colNum = 0;
			for (Integer i : bins) {
				if (i!=-1) colNum++;
			}
			for (Contatto c : contatti) {	
				int count = 0;
				for (int i=0; i<bins.size(); i++){

					switch(bins.indexOf(i)) { 
					case 0:
						if (c.getNome()!=null) {
							fileWriter.write(c.getNome());
						}
						break;
					case 1:
						if (c.getCognome()!=null) {
							fileWriter.write(c.getCognome());
						}
						break;
					case 2:
						if (c.getEmail()!=null) {
							fileWriter.write(c.getEmail());
						}
						break;
					case 3:
						if (c.getTelefono()!=null) {
							fileWriter.write(c.getTelefono());
						}
						break;
					case 4:
						if(c.getNote()!=null) {
							fileWriter.write(c.getNote());
						}
						break;
					case -1:
						continue;
					default:
						System.out.println("anomaly in file writing");
						break;
					}
					if (count<colNum-1) {
						fileWriter.write(separator);
						count++;
					}
				}
				fileWriter.write("\n");
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
		}
	}

	public static void writeXMLfile(List<Contatto> contatti, File file) {
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document doc = null;
			Element rubrica = null;

			if (!file.exists() || file.length()==0){
				doc = documentBuilder.newDocument();
				rubrica = doc.createElement("contatti");
				doc.appendChild(rubrica);//root element
			} else {
				doc = documentBuilder.parse(file);
				rubrica = doc.getDocumentElement();
			}

			for (Contatto c : contatti) {	
				Element contatto = doc.createElement("contatto");

				if(c.getNome()!=null) {
					Element nome = doc.createElement("nome");
					nome.setTextContent(c.getNome());//<nome>Emma</nome>
					contatto.appendChild(nome);
				}

				if(c.getCognome()!=null) {
					Element cognome = doc.createElement("cognome");
					cognome.setTextContent(c.getCognome());//<cognome>Marrone</cognome>
					contatto.appendChild(cognome);
				}

				if(c.getEmail()!=null) {
					Element email = doc.createElement("email");
					email.setTextContent(c.getEmail());
					contatto.appendChild(email);
				}

				if(c.getTelefono()!=null) {
					Element telefono = doc.createElement("telefono");
					telefono.setTextContent(c.getTelefono());
					contatto.appendChild(telefono);
				}

				if(c.getNote()!=null) {
					Element note = doc.createElement("note");
					note.setTextContent(c.getNote());
					contatto.appendChild(note);
				}
				rubrica.appendChild(contatto);
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			StreamResult result = new StreamResult(file);

			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (DOMException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
