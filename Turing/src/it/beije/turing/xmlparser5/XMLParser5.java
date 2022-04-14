package it.beije.turing.xmlparser5;

import java.util.List;

/**
 * 
 * @author Pasqua Alessandro, Luigi Verde
 *
 */
public class XMLParser5 {

	public static void main(String[] args) {
		
		AlberaturaXML m = new AlberaturaXML();
		m.setPath("/temp/test_parser1.xml");
		String stringaContenutoFile = m.getContenutoFile();
		//String stringaContenutoFile = m.getContenutoFile("C:\\Users\\aless\\Desktop\\xml scaricati\\provaintestazione.txt");
		String rootElement = m.getRootElement();
		if(rootElement.contains("XML formattato male")) {
			return;
		}
		List<String> children = m.getChildElements();
	}

	private static AlberaturaXML parse(String string) {
		return null;
	}
	

}
