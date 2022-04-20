package it.beije.turing.xmlparser7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * 
 * @author De Gruttola Luigi, Pitossi Simone
 *
 */
public class XMLParser7 {

	public static void printElements(List<Element> elements, String tabs) {
		for (Element element : elements) {
//			System.out.println(tabs + "element : " + element);
			System.out.println(tabs + "element.getTagName() : " + element.getTagName());
//			System.out.println(tabs + "element.getTextContent() : " + element.getTextContent());
			//System.out.println(tabs + "element.getChildNodes() : " + element.getChildNodes());
			List<Element> innerElements = element.getChildElements();
			System.out.println(tabs + "element.getChildElements() : " + innerElements);
			System.out.println(tabs + "element.getElementsByTagName(\"contatto\") : " + element.getElementsByTagName("contatto"));
			System.out.println(tabs + "element.getElementsByTagName(\"altro\") : " + element.getElementsByTagName("altro"));
			System.out.println(tabs + "element.getAttributes() : " + element.getAttributes());
			System.out.println(tabs + "element.getAttribute(\"name\") : " + element.getAttribute("name"));
			
			if (innerElements != null && !innerElements.isEmpty()) {
				printElements(innerElements, tabs + '\t');
			}
		}
	}
	
	public static void testChallenge(String path) {
		Documento documento = Documento.parse(path);

		Root root = documento.getRootElement();
		System.out.println("root : " + root);
		System.out.println("root.getTagName() : " + root.getTagName());
		System.out.println("root.getTextContent() : " + root.getTextContent());
		//System.out.println("root.getChildNodes() : " + root.getChildNodes());
		List<Element> elements = root.getChildElements();
		System.out.println("root.getChildElements() : " + elements);
		System.out.println("root.getElementsByTagName(\"contatto\") : " + root.getElementsByTagName("contatto"));
		System.out.println("root.getElementsByTagName(\"altro\") : " + root.getElementsByTagName("altro"));
		System.out.println("root.getAttributes() : " + root.getAttributes());
		System.out.println("root.getAttribute(\"question\") : " + root.getAttribute("question"));
		
		printElements(elements, "\t");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		"/Users/simonepitossi/File/test_parser6.xml"
		//"C:/Users/luigi/Downloads/test_parser6.xml"

		//Documento documento = Documento.parse("C:/Users/luigi/Downloads/test_parser6.xml");
//		Documento documento = Documento.parse("/Users/simonepitossi/File/test_parser2.xml");
//		documento.getRootElement().toString();
		
		testChallenge("/tmp/test_parser1.xml");
	}

	/*
getRootElement() //torna l'elemento root ////////////////////////////////////////////////Fatto
getTextContent() //torna il contenuto del tag///////////////////////////////////////////////Fatto
getTagName() //torna il nome del tag////////////////////////////////////////////////Fatto
getAttributes() //torna l'elenco degli attributi dell'elemento////////////////////////////////////////////////Fatto
getAttribute(String attribute) //torna il valore dell'attributo specificato////////////////////////////////////////////////Fatto
getElementsByTagName(String tagName) //torna TUTTI gli elementi con quello specifico nome////////////////////////////////////////////////Fatto
getChildElements() //torna i soli elementi figli dell'elemento su cui viene eseguito////////////////////////////////////////////////Fatto

getChildNodes() //torna tutti i nodi "figli" interni all'elemento su cui viene eseguito

	 */
	
	

}
