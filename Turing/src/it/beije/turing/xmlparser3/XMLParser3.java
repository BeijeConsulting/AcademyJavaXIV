package it.beije.turing.xmlparser3;


import it.beije.turing.xmlparser3.classes.ConcreteElement;
import it.beije.turing.xmlparser3.classes.Documento;
import it.beije.turing.xmlparser3.classes.TreeNode;
import it.beije.turing.xmlparser3.interfaces.Elemento;


import java.io.*;
import java.util.List;


public class XMLParser3 {

	//TODO MODIFICA PER FILE 5 TAG AUTOCHIUDENTE

	//TODO MATCH DI TESTI LUNGHI

	public static void main(String[] args) throws FileNotFoundException {



		Documento d = Documento.getIstance().parse("Turing/res/test_parser1.xml");

		Elemento contatti = d.getRootElement();

		List<TreeNode<Elemento>> contatto = contatti.getChildNodes();

		int i=1;
		for (TreeNode<Elemento> padre:contatto) {
			System.out.println("Padre :"+padre.getData().getTagName()+
					" Lista attr:"+padre.getData().getAttributi());
			System.out.print("\tFiglio "+(i)+": ");

		//	System.out.println("Il valore dell' attributo eta "+padre.getData().getAttribute("eta"));
			System.out.println("//=================ESEGUO getChildren()======================");
			for(TreeNode<Elemento> child :padre.getChildren()) {
				System.out.println( "\t\tNomeTag: " + child.getData().getTagName());
				System.out.println( "\t\tTextContenuto: " + child.getData().getTextContent());
				System.out.println( "\t\tAttributi: " + child.getData().getAttributi());

			}
			System.out.print("\tFiglio "+(i++)+": ");
			System.out.println("//=================ESEGUO getChildElements()======================");

			for(Elemento child :padre.getChildElements()) {
				System.out.println( "\t\tNomeTag: " + child.getTagName());
				System.out.println( "\t\tTextContenuto: " + child.getTextContent());
				System.out.println( "\t\tAttributi: " + child.getAttributi());
			}

			System.out.print("\tFiglio "+(i++)+": ");
			System.out.println("//=================ESEGUO getElementsByTagName()======================");
			for(Elemento child :padre.getElementsByTagName("nome")) {
				System.out.println( "\t\tNomeTag: " + child.getTagName());
				System.out.println( "\t\tTextContenuto: " + child.getTextContent());
				System.out.println( "\t\tAttributi: " + child.getAttributi());
			}


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
