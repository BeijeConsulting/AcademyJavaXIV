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

	List<Contatto> contacts = new ArrayList<>();

	public static void main(String[] args) {
		/*Rubrica rubrica = new Rubrica();
		List<Contatto> contacts =
				rubrica.loadRubricaFromCSV("/temp/rubrica.csv", ";");
		rubrica.writeRubricaCSV(
				contacts, "/temp/NewRubricaCSV.csv", ";");
		
		List<Contatto> contactsXML =
				rubrica.loadRubricaFromXML("/temp/NewRubricaXML.xml");
		
		rubrica.writeRubricaXML(contacts, "/temp/NewRubricaXML.xml");
		rubrica.writeRubricaXML(contactsXML, "/temp/NewRubricaXML2.xml");*/
	}
}
