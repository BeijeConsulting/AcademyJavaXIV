package it.beije.turing.xmlparser5;

import java.util.List;

/**
 * 
 * @author Pasqua Alessandro, Luigi Verde
 *
 */
public class XMLParser5 {

	public static void printElements(List<Tag> elements, String tabs) {
		for (Tag element : elements) {
//			System.out.println(tabs + "element : " + element);
			System.out.println(tabs + "element.getTagName() : " + element.getNome());
//			System.out.println(tabs + "element.getTextContent() : " + element.getTextContent());
			System.out.println(tabs + "element.getChildNodes() : " + element.getChildNodes());
			List<Tag> innerElements = element.getChildren();
			System.out.println(tabs + "element.getChildElements() : " + innerElements);
			System.out.println(tabs + "element.getElementsByTagName(\"contatto\") : " + element.getElementsByTagName("contatto"));
			System.out.println(tabs + "element.getElementsByTagName(\"altro\") : " + element.getElementsByTagName("altro"));
			System.out.println(tabs + "element.getAttributes() : " + element.getAttributi());
			System.out.println(tabs + "element.getAttribute(\"name\") : " + element.getAttribute("name"));
			
			if (innerElements != null && !innerElements.isEmpty()) {
				printElements(innerElements, tabs + '\t');
			}
		}
	}
	
	public static void testChallenge(String path) {
		DocumentoXML doc = parse(path);

		Tag root = doc.getRootElement();
		Tag document = doc.getTreeDocument(root);
//		System.out.println("root : " + root);
		System.out.println("root.getTagName() : " + document.getNome());
		System.out.println("root.getTextContent() : " + document.getContenuto());
		System.out.println("root.getChildNodes() : " + document.getChildNodes());
		List<Tag> elements = document.getChildren();
		System.out.println("root.getChildElements() : " + elements);
		System.out.println("root.getElementsByTagName(\"contatto\") : " + document.getElementsByTagName("contatto"));
		System.out.println("root.getElementsByTagName(\"altro\") : " + document.getElementsByTagName("altro"));
		System.out.println("root.getAttributes() : " + document.getAttributi());
		System.out.println("root.getAttribute(\"question\") : " + document.getAttribute("question"));
		
		printElements(elements, "\t");
	}
	
	public static void main(String[] args) {


		DocumentoXML d = parse("/temp/test_parser1.xml");
		Tag root = d.getRootElement();
		System.out.println(root.getChildren().size());
		Tag doc = d.getTreeDocument(root);

		
		testChallenge("/temp/test_parser2.xml");
	}

	private static DocumentoXML parse(String path) {
		DocumentoXML m = new DocumentoXML();
		String contenutoFile = m.getContenutoFile(path);
		m.setStringaFile(contenutoFile);
		return m;
	}

}
