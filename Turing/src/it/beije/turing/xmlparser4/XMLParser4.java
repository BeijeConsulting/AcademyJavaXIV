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
		FileParser fp = new FileParser();

		List<String> list=fp.parseFile("tmp/test_parser4.xml");

		XMLinterpreter xml = new XMLinterpreter(list);
		xml.print();
		test(xml);
		//xml.print();
		/*try {
			Node root=xml.ParseRoot();
			System.out.println("root ok");
			List<Node> nodes= new ArrayList<>();
			List<Node> nodes2= new ArrayList<>();
			nodes=root.getChildNodes();
			Node nodo1 = null;
			for (Node el: nodes){
				nodo1=el;
			
			System.out.println(nodo1.getTagName());
			nodes2=nodo1.getChildNodes();
			for (Node el2: nodo1.getChildNodes()){
				System.out.println(el2.getTagName());
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}
	private static void test2()
	{
		
	}
	private static void test(XMLinterpreter tool)
	{
		Node root=null;
		try {
			 root = tool.ParseRoot();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
