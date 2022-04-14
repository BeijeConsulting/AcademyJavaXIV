package it.beije.turing.xmlparser5;

import java.util.List;

/**
 * 
 * @author Pasqua Alessandro, Luigi Verde
 *
 */
public class XMLParser5 {

	public static void main(String[] args) {
		
		//DocumentoXML d = parse("/temp/test_parser1.xml");
		DocumentoXML d = parse("C:\\Users\\aless\\Desktop\\xml scaricati\\test_parser1.xml");
		String s = d.removeDeclarationTag();
		System.out.println(s);
	}

	private static DocumentoXML parse(String path) {
		DocumentoXML m = new DocumentoXML();
		String contenutoFile = m.getContenutoFile(path);
		m.setStringaFile(contenutoFile);
		return m;
	}
	

}
