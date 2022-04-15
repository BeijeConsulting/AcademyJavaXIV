package it.beije.turing.xmlparser5;

import java.util.List;

/**
 * 
 * @author Pasqua Alessandro, Luigi Verde
 *
 */
public class XMLParser5 {

	public static void main(String[] args) {

//		DocumentoXML d = parse("/temp/test_parser1.xml");
		DocumentoXML d = parse("C:\\Users\\aless\\Desktop\\xml scaricati\\test_parser1.xml");
//		DocumentoXML d = parse("C:\\Users\\aless\\Desktop\\xml scaricati\\test_parser1 - Copia.xml");
		Tag root = d.getRootElement();
//		System.out.println(root.toString());

		// dobbiamo lavorare con la root.
		// dalla variabile root dobbiamo chiamare gli altri metodi

		Tag doc = d.buildDoc(root);
//		System.out.println(doc.toString());
//		List<Tag> lista = doc.getElementsByTagName("contatto");
//		for (Tag tag : lista) {
//			System.out.println(tag.toString());
//		}
//		List<Tag> lista = doc.getElementsByTagName("nome");
//		System.out.println("dimensione lista" + lista.size());
//		for (Tag tag : lista) {
//			System.out.println(tag.toString());
//		}
//		
//		List<Tag> l2 = doc.getElementsByTagName("contatto");
//		System.out.println("dimensione lista" + l2.size());
//		for (Tag tag : l2) {
//			System.out.println(tag.toString());
//		}
		
		List<Nodo> l3 = root.getChildNodes();
		
		

	}

	private static DocumentoXML parse(String path) {
		DocumentoXML m = new DocumentoXML();
		String contenutoFile = m.getContenutoFile(path);
		m.setStringaFile(contenutoFile);
		return m;
	}

}
