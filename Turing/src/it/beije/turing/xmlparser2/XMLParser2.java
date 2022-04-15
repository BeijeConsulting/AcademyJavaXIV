package it.beije.turing.xmlparser2;

import java.io.IOException;
import java.util.ArrayList;

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

	public static void main(String[] args) throws IOException, SAXException {
		
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
