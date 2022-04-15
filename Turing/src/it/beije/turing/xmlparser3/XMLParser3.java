package it.beije.turing.xmlparser3;


import it.beije.turing.xmlparser3.classes.ConcreteElement;
import it.beije.turing.xmlparser3.classes.Documento;
import it.beije.turing.xmlparser3.classes.TreeNode;
import it.beije.turing.xmlparser3.interfaces.Elemento;


import java.io.*;
import java.util.List;


public class XMLParser3 {
	//TODO MODIFICA PER FILE 5 TAG AUTOCHIUDENTE

	public static void main(String[] args) throws FileNotFoundException {



		Documento d = Documento.getIstance().parse("Turing/res/test_parser1.xml");

		Elemento contatti = d.getRootElement();

		List<TreeNode<Elemento>> contatto = contatti.getChildNodes();

		for (TreeNode<Elemento> padre:contatto) {
			for(TreeNode<Elemento> child :padre.getChildren()) {
				System.out.println( "\n\t" + child.getData().toString() + " | Parente: " + (child.getParent() == null ? "None" : child.getParent().getData()));
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
