package it.beije.turing.xmlparser3;

import it.beije.turing.xmlparser3.classes.Documento;
import it.beije.turing.xmlparser3.classes.TreeNode;
import it.beije.turing.xmlparser3.interfaces.Elemento;


import java.io.*;
import java.util.List;


public class XMLParser3 {


	public static void main(String[] args) throws FileNotFoundException {


		Documento d = Documento.getIstance().parse("Turing/res/test_parser6.xml");

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
