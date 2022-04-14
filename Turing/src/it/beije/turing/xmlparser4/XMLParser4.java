package it.beije.turing.xmlparser4;

import java.util.ArrayList;
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
<<<<<<< HEAD
		List<String> list=fp.parseFile("tmp/test_parser1.xml");
=======
>>>>>>> origin/XMLParser4_sancesario
		XMLinterpreter xml = new XMLinterpreter(list);
		//xml.print();
		try {
			Node root=xml.ParseRoot();
			System.out.println("blocl");
			List<Node> nodes= new ArrayList<>();
			List<Node> nodes2= new ArrayList<>();
			nodes=root.getChildNodes();
			Node nodo1 = null;
			for (Node el: nodes){
				nodo1=el;
			}
			System.out.println(nodo1.getTagName());
			nodes2=nodo1.getChildNodes();
			for (Node el2: nodo1.getChildNodes()){
				System.out.println(el2);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
