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

	public static void main(String[] args) 
	{
		DocXml doc = DocXml.parse("tmp/test_parser2.xml");
		//xml.print();
		test2(doc);
	}
	private static void test2(DocXml doc)
	{
		Node root=doc.getRootElement();
		System.out.println(root.getElementsByTagName("nome").get(0).getAttribute(""));
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
