package it.beije.turing.xmlparser5;

import java.util.List;

/**
 * 
 * @author Pasqua Alessandro, Luigi Verde
 *
 */
public class XMLParser5 {

	public static void main(String[] args) {

		DocumentoXML d = parse("/temp/test_parser1.xml");
//		DocumentoXML d = parse("C:\\Users\\aless\\Desktop\\xml scaricati\\test_parser1.xml");
//		DocumentoXML d = parse("C:\\Users\\aless\\Desktop\\xml scaricati\\test_parser1 - Copia.xml");
		Tag root = d.getRootElement();

		Tag doc = d.buildDoc(root);
		
		List<Nodo> l3 = root.getChildNodes();

	}

	private static DocumentoXML parse(String path) {
		DocumentoXML m = new DocumentoXML();
		String contenutoFile = m.getContenutoFile(path);
		m.setStringaFile(contenutoFile);
		return m;
	}

}
