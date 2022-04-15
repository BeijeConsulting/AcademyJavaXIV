package it.beije.turing.xmlparser4;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Cognome Nome, Cognome Nome
 *
 */
public class XMLParser4 {

	public static void main(String[] args) 
	{
		DocXml doc = DocXml.parse("C:\\Users\\39346\\IdeaProjects\\AcademyJavaXIV\\Turing\\tmp\\test_parser1.xml");
		//xml.print();
		test2(doc);
	}
	private static void test2(DocXml doc)
	{
		Node root=doc.getRootElement();
		for(Node node : root.getElementsByTagName("contatti"))
		{
			System.out.println(node.getTagName());
		}
		
	}
	private static void test(DocXml doc)
	{
		Node root=doc.getRootElement();
		System.out.println("il root è: "+root.getTagName());
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
	}

}
