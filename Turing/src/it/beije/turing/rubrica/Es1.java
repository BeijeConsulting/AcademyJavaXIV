package it.beije.turing.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import org.xml.sax.SAXException;

public class Es1 {
	/* implementate metodi analoghi a questi:
	public List<Contatto> loadRubricaFromCSV(String pathFile, String separator) {...}
	
	public void writeRubricaCSV(List<Contatto> contatti, String pathFile, String separator) {...}
	public void writeRubricaCSV(List<Contatto> contatti, String pathFile, String separator) {...}
	naturalmente lascio a voi la gestione di eventuali eccezioni.
	Dopo i metodi base per la scrittura, fate in modo che se indicate un file xml o 
	csv già esistente, i nuovi contatti non vadano a sovrascrivere quelli già presenti, bensì vengano aggiunti 
	in coda*/
	
	public static List<Contatto> loadRubricaFromCSV(String pathFile, String separator) {
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
				//System.out.println('\n' +""+ ++c + " " + row  );
				
				//row = row.substring(1, row.length()-1);
				String[] columns = row.split(separator);
			for (String col : columns) {	
				
				contatto = new Contatto();
				if(!columns[0].equalsIgnoreCase("")){
					contatto.setCognome(columns[0]);
					} 
				else {
					contatto.setCognome("");
				}
				
				if(columns.length > 1) 
						contatto.setNome(columns[1]);
				

				if(columns.length > 2)
					contatto.setEmail(columns[2]);
				
				
				if(columns.length > 3) 
					contatto.setTelefono(columns[3]);
				
				if(columns.length > 4)
					contatto.setNote(columns[4]);
					
				}
			
				//System.out.println(contatto);
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
		
		//System.out.println("contatti: " + contatti.size());
		return contatti;
		
	}
	
	
//	public List<Contatto> loadRubricaFromXML(String pathFile) {
//		
//	}
	
	public static void writeRubricaXML(List<Contatto> cont, String pathFile) throws TransformerException {
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = null;
		Document doc = null;
		
		Element contatto;
		Element nome;
		Element cognome;
		Element telefono;
		Element email;
		Element note;
		
		 
		 
		try {
			 documentBuilder = documentBuilderFactory.newDocumentBuilder();
			  
			 doc = documentBuilder.newDocument();
			 
			 Element contatti  = doc.createElement("contatti");
			 doc.appendChild(contatti);
			 
			 for (Contatto c : cont) {
				 Element contact = doc.createElement("contatto");
				
				 nome = doc.createElement("nome");
				 nome.setTextContent(c.getNome());
				 contact.appendChild(nome);
				 
				 cognome = doc.createElement("cognome");
				 nome.setTextContent(c.getCognome());
				 contact.appendChild(cognome);
			 

			}
			 
			 
		} catch (ParserConfigurationException pcEx) {
			pcEx.printStackTrace();			
		}finally {
		
		// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				
				StreamResult result = new StreamResult(new File(pathFile));

				// Output to console for testing
				StreamResult syso = new StreamResult(System.out);

				transformer.transform(source, result);
				transformer.transform(source, syso);
		}
	}
	
	
	
	public static void main(String[] args) throws TransformerException  {
		
		List<Contatto> prova = loadRubricaFromCSV("/Users/matteoprovezza/Desktop/Beije/AcademyJavaXIV/dir/Turing/src/File/temp/rubrica.csv", ";");
		
		writeRubricaXML(prova, "/Users/matteoprovezza/Desktop/Beije/AcademyJavaXIV/dir/Turing/src/File/temp/prova123.xml");
	}
	

}
