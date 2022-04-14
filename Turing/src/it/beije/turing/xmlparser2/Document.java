package it.beije.turing.xmlparser2;

import java.io.IOException;
import java.util.ArrayList;

public class Document {
	ArrayList<StringBuilder> content = new ArrayList<StringBuilder>();
	Element root = new Element();
	
	public Document(StringBuilder fileContent) {
		StringBuilder strSup = new StringBuilder();
		StringBuilder strC = new StringBuilder();
		
		for(int i = 0, j = 0, x = 0, y = 0; i < fileContent.length(); i++) {
			char c = fileContent.charAt(i);

			//System.out.println(strSup);
			
			if(i > 2 && fileContent.charAt(i - 1) == '>' && c != '<' && c != '>') {
				y++;
				strC.append("t-");
			}
			if(y == 1 && c != '<') {
				strC.append(c);
			}
			
			if(y == 1 && c == '<') {
				y--;
				content.add(strC);
				strC = new StringBuilder();
			}
			
			if(c == '<' && fileContent.charAt(i + 1) != '?') {
				j++;
			}
			if(j == 1) {
				if(c != '<' && c != '>' && c != '/') {					
					strSup.append(c);
				}
				if(c == ' ' && strSup.indexOf("(") == -1) {
					strSup.append('(');
					x++;
				}
			}
			
			if(c == '>' && fileContent.charAt(i - 1) != '?') {
				
				if(x == 1) {
					strSup.append(')');
					x--;
				}
				
				if(fileContent.charAt(i - 1) == '/') {
					strSup.append("**");
				}
				
				j--;
				content.add(strSup);
				strSup = new StringBuilder();
			} 
			
			
		}
		
		
		ArrayList<StringBuilder> contentSup = new ArrayList<StringBuilder>(content);
		//root.setTag(contentSup.get(i++).toString());
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
		//String element = contentSup.get(i++).toString();
		int countChildren = 0;
		//for(StringBuilder s : )
		ArrayList<Node> parentList = new ArrayList<Node>();
		ArrayList<Node> nodes = new ArrayList<Node>();
		Node root = new Node();
		root.content = contentSup.get(0).toString();
		parentList.add(root);
		for(int i = 1; i < contentSup.size(); i++) {
			Node node = new Node();
			node.content = contentSup.get(i).toString();
			if(!node.content.equals(parentList.get(parentList.size() - 1).content) && !node.content.toString().contains("t-") && !node.content.toString().contains("**")) {
				node.parent = parentList.get(parentList.size() - 1);
				parentList.get(parentList.size() - 1).child.add(node);
				parentList.add(node);
				//nodes.add(node);
			} else if(node.content.toString().contains("t-") || node.content.toString().contains("**")) {
				node.parent = parentList.get(parentList.size() - 1);
				parentList.get(parentList.size() - 1).child.add(node);
				nodes.add(node);
			} else if(node.content.equals(parentList.get(parentList.size() - 1).content)) {
				nodes.add(parentList.get(parentList.size() - 1));
				parentList.remove(parentList.size() - 1);
			}
			
			//root.child.add(node);
		}
		
		for(Node node : root.child) {
			System.out.println(node.content);
			for(Node node1 : node.child) {
				System.out.println("   " + node1.content);
				for(Node node2 : node1.child) {
					System.out.println("       " + node2.content);
				}
			}
		}
	}
	
	public static ArrayList<Element> buildRoot(ArrayList<StringBuilder> content, int i, ArrayList<Element> elements) {
		
		Element e = null;
		
		if (i < content.size() - 1) {
			if(!content.get(i).equals(content.get(i + 1)) && !content.get(i + 1).toString().contains("t-")) {
				e = new Element();
				e.setTag(content.get(i).toString());
				e.setChildElements(buildRoot(content, ++i, elements));
			} else if(content.get(i + 1).toString().contains("t-")) {
				e = new Element();
				e.setTag(content.get(i).toString());
				e.setContent(content.get(i + 1).substring(2, content.get(i + 1).length()));
				e.setChildElements(buildRoot(content, ++i, elements));
			} else {
				//elements.add(e);
			}
		}
		
		elements.add(e);
		//elements.get((elements.size() - 1)).setChildElements(elements);
		return elements;
	}
	
	
	public static void main(String... args) throws IOException {
		
		Document elm = new Document(XML_Reader.readText("/Users/lorenzoorru0/Desktop/CSVjava/rubrica.xml"));
		System.out.println(elm.content);
	}
}
