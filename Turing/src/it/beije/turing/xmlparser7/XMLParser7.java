package it.beije.turing.xmlparser7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Cognome Nome, Cognome Nome
 *
 */
public class XMLParser7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		"/Users/simonepitossi/File/test_parser6.xml"
		//"C:/Users/luigi/Downloads/test_parser6.xml"

		//Documento.XMLToString("C:/Users/luigi/Downloads/test_parser6.xml");
		Root.creaInstanzaRoot(Documento.XMLToString("C:/Users/luigi/Downloads/test_parser6.xml"));
	}

	/*
getRootElement() //torna l'elemento root
getChildNodes() //torna tutti i nodi "figli" interni all'elemento su cui viene eseguito
getChildElements() //torna i soli elementi figli dell'elemento su cui viene eseguito
getElementsByTagName(String tagName) //torna TUTTI gli elementi con quello specifico nome
getTagName() //torna il nome del tag
getTextContent() //torna il contenuto del tag
getAttributes() //torna l'elenco degli attributi dell'elemento
getAttribute(String attribute) //torna il valore dell'attributo specificato
	 */
	
	

}
