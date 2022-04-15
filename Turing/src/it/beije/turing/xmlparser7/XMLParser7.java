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
		Documento documento = Documento.parse("/Users/simonepitossi/File/test_parser6.xml");
		System.out.println(documento.getRootElement().getCampi().get(0).getElementsByTagName("value"));
	}

	/*
getRootElement() //torna l'elemento root ////////////////////////////////////////////////Fatto

getChildElements() //torna i soli elementi figli dell'elemento su cui viene eseguito
getTextContent() //torna il contenuto del tag

getTagName() //torna il nome del tag////////////////////////////////////////////////Fatto
getAttributes() //torna l'elenco degli attributi dell'elemento////////////////////////////////////////////////Fatto
getAttribute(String attribute) //torna il valore dell'attributo specificato////////////////////////////////////////////////Fatto
getElementsByTagName(String tagName) //torna TUTTI gli elementi con quello specifico nome////////////////////////////////////////////////Fatto


getChildNodes() //torna tutti i nodi "figli" interni all'elemento su cui viene eseguito

	 */
	
	

}
