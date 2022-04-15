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

		ArrayList<StringBuilder> contentSup = new ArrayList<StringBuilder>(content);
		// root.setTag(contentSup.get(i++).toString());
//		contentSup.remove(contentSup.size() - 1);
//		contentSup.remove(0);
//		System.out.println(contentSup);
//		int i = 1;
//		ArrayList<Element> elms = new ArrayList<Element>();
//		ArrayList<Element> elmsP = buildRoot(contentSup, i, elms);
//		for(Element e : elmsP) {
//			if(e != null) {				
//				System.out.println(e.getTag() + " " + e.getContent());
//			}
//		}
		Node root = Node.getNodes(contentSup);
		Element e = new Element(root);
		e.setChildElements(getRootElement(root));
		
		

		for (Element el : e.getChildElements()) {
			System.out.println(el.tag);
			for (Element ez : el.getChildElements()) {
				System.out.println("         " + ez.tag);
			}

		}System.out.println("Count : " + count);
		/*
		 * for(Node node : root.child) { System.out.println(node.tag); for(Node node1 :
		 * node.child) { System.out.println("   " + node1.tag); for(Node node2 :
		 * node1.child) { System.out.println("       " + node2.tag); } } }
		 */
	}
	public static int count = 0;
	public ArrayList<Element> getRootElement(Node node) {
		Element current = new Element(node);
		ArrayList<Node> nodes = new ArrayList<>();
		nodes = (ArrayList)current.child.clone();
		count++;
		//System.out.println(node.child);
		
		//System.out.println(current.child.size());
		//System.out.println(nodes.size());
		
		System.out.println("Prova" + current.child.get(1).child.get(1).tag);
		for (Node n : current.child) {
			System.out.println(n.tag.substring(0, 2).equals("t-"));
			//System.out.println(nodes.size());
			
			while (!nodes.isEmpty()) {
				System.out.println("Nodes.size = " + nodes.size());
				/*
				if (!(n.tag.substring(0, 2).equals("t-"))) {
					current.setChildElements(new Element(n));
					System.out.println(nodes.size());
					nodes.remove(0);
					System.out.println(nodes.size());
				}*/
				for(int i = 0; i < n.child.size(); i++) {
					System.out.println("SON QUI");
					System.out.println(n.child.get(i).tag);
				}
				
				if (!(n.tag.substring(0, 2).equals("t-"))) {
					System.out.println("IF");
					current.setChildElements(getRootElement(new Node(n)));
					nodes.remove(0);
				}
				else{
					System.out.println("ELSE");
					current.setContent(n.tag);		
					nodes.remove(0);
				}
				
			}
			
		}
		
		return current.getChildElements();
	}

	public Element getChildElements(ArrayList<Node> nodes) {
		Node node = null;
		Element ele = null;
		for (Node n : nodes) {
			String content = "";
			for (Node n2 : n.child) {
				if (n2.tag.contains("t-")) {
					content += n2.tag;
				}
			}
			if (!n.child.isEmpty()) {

				// node = (Element)n;
				ele = new Element(n);
				ele.setContent(content);
				ele.setChildElements(getChildElements(n.child));

			}
		}
		return ele;
	}

	public static void main(String... args) throws IOException {

		Document elm = new Document(XML_Reader.readText("C:\\Users\\Marco\\Desktop\\test_parser1.xml"));
		System.out.println(elm.content);
	}
}
