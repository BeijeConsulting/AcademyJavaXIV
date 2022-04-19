package it.beije.turing.xmlparser3;

import it.beije.turing.xmlparser3.classes.Documento;
import it.beije.turing.xmlparser3.classes.TreeNode;
import it.beije.turing.xmlparser3.interfaces.Elemento;


import java.io.*;
import java.util.List;


public class XMLParser3 {

//	public static void printElements(List<Node> elements, String tabs) {
//		for (Node element : elements) {
////			System.out.println(tabs + "element : " + element);
//			System.out.println(tabs + "element.getTagName() : " + element.getTagName());
////			System.out.println(tabs + "element.getTextContent() : " + element.getTextContent());
//			System.out.println(tabs + "element.getChildNodes() : " + element.getChildNodes());
//			List<Node> innerElements = element.getChildElements();
//			System.out.println(tabs + "element.getChildElements() : " + innerElements);
//			System.out.println(tabs + "element.getElementsByTagName(\"contatto\") : " + element.getElementsByTagName("contatto"));
//			System.out.println(tabs + "element.getElementsByTagName(\"altro\") : " + element.getElementsByTagName("altro"));
//			System.out.println(tabs + "element.getAttributes() : " + element.getAttributes());
//			System.out.println(tabs + "element.getAttribute(\"name\") : " + element.getAttribute("name"));
//			
//			if (innerElements != null && !innerElements.isEmpty()) {
//				printElements(innerElements, tabs + '\t');
//			}
//		}
//	}
//	
//	public static void testChallenge(String path) {
//		Documento d = Documento.getIstance().parse(path);
//
//		Elemento root = d.getRootElement();
////		System.out.println("root : " + root);
//		System.out.println("root.getTagName() : " + root.getTagName());
//		System.out.println("root.getTextContent() : " + root.getTextContent());
//		List<TreeNode<Elemento>> nodes = root.getChildNodes();
//		System.out.println("root.getChildNodes() : " + nodes);
////		System.out.println("root.getChildElements() : " + elements);
//		System.out.println("root.getElementsByTagName(\"contatto\") : " + root.getElementsByTagName("contatto"));
//		System.out.println("root.getElementsByTagName(\"altro\") : " + root.getElementsByTagName("altro"));
//		System.out.println("root.getAttributes() : " + root.getAttributes());
//		System.out.println("root.getAttribute(\"question\") : " + root.getAttribute("question"));
//		
//		printElements(elements, "\t");
//	}
//
//	public static void main(String[] args) {
//		testChallenge("/tmp/test_parser1.xml");
//	}

	public static void main(String[] args) throws FileNotFoundException {
		Documento d = Documento.getIstance().parse("/tmp/test_parser2.xml");//"Turing/res/test_parser6.xml");

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
	}

}
