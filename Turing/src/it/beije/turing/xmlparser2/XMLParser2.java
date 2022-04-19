package it.beije.turing.xmlparser2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.SAXException;

/**
 * 
 * @author Nardella Marco, Lorenzo Orr�
 * 	Il parser dovr� leggere e "costruire" in memoria l'alberatura del file XML partendo da un metodo
 *
 *	public static VostroOggettoDocumento parse(String file) {...}
 *
 *	che restituir� appunto un VostroOggettoDocumento (nome che deciderete voi).
 *
 *	I metodi da implementare sono:
 *
 *	getRootElement() //torna l'elemento root
 *	getChildNodes() //torna tutti i nodi "figli" interni all'elemento su cui viene eseguito
 *	getChildElements() //torna i soli elementi figli dell'elemento su cui viene eseguito
 *	getElementsByTagName(String tagName) //torna TUTTI gli elementi con quello specifico nome
 *	getTagName() //torna il nome del tag
 *	getTextContent() //torna il contenuto del tag
 *	getAttributes() //torna l'elenco degli attributi dell'elemento
 *	getAttribute(String attribute) //torna il valore dell'attributo specificato
 *
 */
public class XMLParser2 {

	public static void printElements(List<Element> elements, String tabs) {
		for (Element element : elements) {
//			System.out.println(tabs + "element : " + element);
			System.out.println(tabs + "element.getTagName() : " + element.getTagName());
//			System.out.println(tabs + "element.getTextContent() : " + element.getTextContent());
			System.out.println(tabs + "element.getChildNodes() : " + element.getChildNodes());
			List<Element> innerElements = element.getChildElements();
			System.out.println(tabs + "element.getChildElements() : " + innerElements);
			System.out.println(tabs + "element.getElementsByTagName(\"contatto\") : " + element.getElementsByTagName("contatto"));
			System.out.println(tabs + "element.getElementsByTagName(\"altro\") : " + element.getElementsByTagName("altro"));
			System.out.println(tabs + "element.getAttributes() : " + element.getAttributes());
			System.out.println(tabs + "element.getAttribute(\"name\") : " + element.getAttribute("name"));
			
			if (innerElements != null && !innerElements.isEmpty()) {
				printElements(innerElements, tabs + '\t');
			}
		}
	}
	
	public static void testChallenge(String path) throws IOException, SAXException {
		Document document = new Document(XML_Reader.readText(path));
		ArrayList<StringBuilder> contentSup = new ArrayList<StringBuilder>(document.content);

		Node rootNode = Node.getNodes(contentSup);
		Element root = document.getRootElement(rootNode);
		
//		System.out.println("root : " + root);
		System.out.println("root.getTagName() : " + root.getTagName());
		System.out.println("root.getTextContent() : " + root.getTextContent());
		System.out.println("root.getChildNodes() : " + root.getChildNodes());
		List<Element> elements = root.getChildElements();
		System.out.println("root.getChildElements() : " + elements);
		System.out.println("root.getElementsByTagName(\"contatto\") : " + root.getElementsByTagName("contatto"));
		System.out.println("root.getElementsByTagName(\"altro\") : " + root.getElementsByTagName("altro"));
		System.out.println("root.getAttributes() : " + root.getAttributes());
		System.out.println("root.getAttribute(\"question\") : " + root.getAttribute("question"));
		
		printElements(elements, "\t");
	}

	public static void main(String[] args) throws IOException, SAXException {
		
		testChallenge("/tmp/test_parser6.xml");
	}

	public static void main2(String[] args) throws IOException, SAXException {
		
		Document document = new Document(XML_Reader.readText("/Users/lorenzoorru0/Desktop/CSVjava/test_parser6.xml"));
		//System.out.println(document.content);
		
		ArrayList<StringBuilder> contentSup = new ArrayList<StringBuilder>(document.content);

		Node root = Node.getNodes(contentSup);
		
		Element rootElm = document.getRootElement(root);

		System.out.println(rootElm.getChildElements().size());
		for (Element el : rootElm.getChildElements()) {
			System.out.println(el.tag);
			if(el.getAttributes() != null) {
				System.out.println(el.getAttributes().get(0).getName() + ": " + el.getAttributes().get(0).getValue());
			}
			for (Element el1 : el.getChildElements()) {
				System.out.println("	" + el1.tag);
				System.out.println("		" + el1.getTextContent());
				if(el1.getChildElements().size() != 0) {
					for(Element el2 : el1.getChildElements()) {
						System.out.println("			" + el2.tag);
						System.out.println("				" + el2.getTextContent());
					}
				}
			}
		}
		
		//Test nodes' print
//		for(Node node : root.child) { 
//			System.out.println(node.tag); 
//			for(Node node1 : node.child) { 
//				System.out.println("   " + node1.tag); 
//				for(Node node2 : node1.child) { 
//					System.out.println("       " + node2.tag); 
//				} 
//			} 
//		}

	}

}
