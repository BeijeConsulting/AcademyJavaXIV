package it.beije.turing.xmlparser4;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.Attribute;

/**
 * 
 * @author Frontini Luca, Sancesario Giuseppe
 *
 */
public class XMLParser4 {

	public static void printElements(List<Node> elements, String tabs) {
		for (Node element : elements) {
//			System.out.println(tabs + "element : " + element);
			System.out.println(tabs + "element.getTagName() : " + element.getTagName());
//			System.out.println(tabs + "element.getTextContent() : " + element.getTextContent());
			System.out.println(tabs + "element.getChildNodes() : " + element.getChildNodes());
			List<Node> innerElements = element.getChildElements();
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
	
	public static void testChallenge(String path) {
		DocXml doc = DocXml.parse(path);

		Node root = doc.getRootElement();
//		System.out.println("root : " + root);
		System.out.println("root.getTagName() : " + root.getTagName());
		System.out.println("root.getTextContent() : " + root.getTextContent());
		System.out.println("root.getChildNodes() : " + root.getChildNodes());
		List<Node> elements = root.getChildElements();
		System.out.println("root.getChildElements() : " + elements);
		System.out.println("root.getElementsByTagName(\"contatto\") : " + root.getElementsByTagName("contatto"));
		System.out.println("root.getElementsByTagName(\"altro\") : " + root.getElementsByTagName("altro"));
		System.out.println("root.getAttributes() : " + root.getAttributes());
		System.out.println("root.getAttribute(\"question\") : " + root.getAttribute("question"));
		
		printElements(elements, "\t");
	}

	public static void main(String[] args) 
	{
		//DocXml doc = DocXml.parse("tmp/test_parser1.xml");
		//xml.print();
		//test(doc);
		
		testChallenge("tmp/test_parser1.xml");
	}

	private static void test2(DocXml doc)
	{
		Node root=doc.getRootElement();
		
		//System.out.println(root.getElementsByTagName("nome").get(0).getAttribute(""));
		System.out.println(root.getTextContent());
	}
	private static void test(DocXml doc)
	{
		Node root=doc.getRootElement();
		System.out.println("il root ши: "+root.getTagName());
		if(root.hasChildren())
		{
			List<Node> children = root.getChildNodes();
			System.out.println("ed ha "+children.size()+" figli:");
			for(Node child:children)
			{
				PrintMessage(child);
			}
		}
	}
	private static void PrintMessage(Node node)
	{
		List<Node> children=null;
		System.out.println(node.getTagName()+(node.hasChildren()?" con "+(children=node.getChildNodes()).size()+" figli:":""));
		if(children!=null)
		{
			for(Node child:children)
			{
				PrintMessage(child);
			}
		}
		
		if(node.hasAttributes())	
		{
			List<Attributes> attributes= node.getAttributes();
		System.out.println("ed attributi:");
		for(Attributes att:attributes)
		{
			System.out.println(att);
		}
		}
		
	}

}
