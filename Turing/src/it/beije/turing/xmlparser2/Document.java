package it.beije.turing.xmlparser2;

import java.io.IOException;
import java.util.ArrayList;

public class Document {
	ArrayList<StringBuilder> content = new ArrayList<StringBuilder>();
	Element root = null;

	public Document(StringBuilder fileContent) {
		StringBuilder strSup = new StringBuilder();
		StringBuilder strC = new StringBuilder();

		for (int i = 0, j = 0, x = 0, y = 0; i < fileContent.length(); i++) {
			char c = fileContent.charAt(i);

			// System.out.println(strSup);

			if (i > 2 && fileContent.charAt(i - 1) == '>' && c != '<' && c != '>') {
				y++;
				strC.append("t-");
			}
			if (y == 1 && c != '<') {
				strC.append(c);
			}

			if (y == 1 && c == '<') {
				y--;
				content.add(strC);
				strC = new StringBuilder();
			}

			if (c == '<' && fileContent.charAt(i + 1) != '?') {
				j++;
			}
			if (j == 1) {
				if (c != '<' && c != '>' && c != '/') {
					strSup.append(c);
				}
				if (c == ' ' && strSup.indexOf("(") == -1) {
					strSup.append('(');
					x++;
				}
			}

			if (c == '>' && fileContent.charAt(i - 1) != '?') {

				if (x == 1) {
					strSup.append(')');
					x--;
				}

				if (fileContent.charAt(i - 1) == '/') {
					strSup.append("**");
				}

				j--;
				content.add(strSup);
				strSup = new StringBuilder();
			}

		}
	}
	
	public Element getRootElement(Node node) {
		Element rootElm = new Element(node);
		
		rootElm.setAttributes(node);
		
		return rootElm;
	}

	public static void main(String... args) throws IOException {

		Document document = new Document(XML_Reader.readText("/Users/lorenzoorru0/Desktop/CSVjava/test_parser1.xml"));
		//System.out.println(document.content);
		
		ArrayList<StringBuilder> contentSup = new ArrayList<StringBuilder>(document.content);

		Node root = Node.getNodes(contentSup);
		
		Element rootElm = document.getRootElement(root);
		System.out.println(rootElm.getAttributes().get(0).getName() + ": " + rootElm.getAttributes().get(0).getValue());

		System.out.println(rootElm.getChildElements().size());
		for (Element el : rootElm.getChildElements()) {
			System.out.println(el.tag);
			if(el.getAttributes() != null) {
				System.out.println(el.getAttributes().get(0).getName() + ": " + el.getAttributes().get(0).getValue());
			}
			for (Element el1 : el.getChildElements()) {
				System.out.println("	" + el1.tag);
				System.out.println("		" + el1.getTextContent());
			}
		}
		
//		ArrayList<Node> rootChildNodes = rootElm.getChildNodes();
//		for(Node n : rootChildNodes) {
//			System.out.println(n.tag);
//		}
		
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
