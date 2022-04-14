package it.beije.turing.xmlparser4;

import java.util.List;

/**
 * 
 * @author Cognome Nome, Cognome Nome
 *
 */
public class XMLParser4 {

	public static void main(String[] args) {
		FileParser fp = new FileParser();
		List<String> list=fp.parseFile("tmp/test_parser1.xml");
		System.out.println(list.get(1));
	}

}
