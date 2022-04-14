package it.beije.turing.xmlparser3;


import it.beije.turing.xmlparser3.classes.Documento;
import it.beije.turing.xmlparser3.classes.Elemento;
import it.beije.turing.xmlparser3.classes.Nodo;

import java.util.List;


public class XMLParser3 {

	public static void main(String[] args) {
		String path="C:\\temp\\challenge\\test_parser1.xml";
		System.out.println("ciao");
		Documento d = Documento.getIstance().parse(path);
/*
		Elemento root=d.getRootElement(); //restiisce elemento ROOT

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
