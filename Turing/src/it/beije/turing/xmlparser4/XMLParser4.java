package it.beije.turing.xmlparser4;

import java.util.List;

/**
 * 
 * @author Cognome Nome, Cognome Nome
 *
 */
public class XMLParser4 {

	public static void main(String[] args) 
	{
		FileParser fp = new FileParser();
		List<String> list=fp.parseFile("tmp/test_parser7.xml");
		XMLinterpreter xml = new XMLinterpreter(list);
		//xml.print();
		try {
			Node root=xml.ParseRoot();
			System.out.println("blocl");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
