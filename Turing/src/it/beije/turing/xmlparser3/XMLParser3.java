package it.beije.turing.xmlparser3;


import it.beije.turing.xmlparser3.classes.Documento;
import it.beije.turing.xmlparser3.interfaces.Elemento;
import it.beije.turing.xmlparser3.interfaces.Node;


import java.io.*;
import java.util.List;


public class XMLParser3 {

	public static void main(String[] args) throws FileNotFoundException {



		Documento d = Documento.getIstance().parse("Turing/res/test_parser1.xml");

		Elemento contatti = d.getRootElement();

		List<Node>  contatto = contatti.getListChiled();

		List<Node> listNode = contatto.get(0).getListChiled();

		for (Node n:listNode) {
			Elemento nome = n.getElementsByTagName("Nome");
			//e.getAttributi().getAttributes("name");
			Elemento cognome = n.getElementsByTagName("Cognome");
			//e.getAttributi();
		}





/*
		Elemento root = d.getRootElement(); //restiisce elemento ROOT

		root.getAttributes();

		List<Nodo> nodeList=root.getChildNodes();

		for (Nodo n: nodeList) {
			Elemento element=n.getChildElement();
			System.out.println("TagName"+element.getTagName());
			System.out.println("TextContent"+element.getTextContent());

			List<String> attrs=element.getAttributes();

			for (String attr:attrs) {
				System.out.println("TextAttr"+element.getAttribute(attr));
			}

			List<Elemento> listElement=element.getElementsByTagName("NOME");
		}

*/
	}

}
