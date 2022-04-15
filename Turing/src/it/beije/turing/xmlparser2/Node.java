package it.beije.turing.xmlparser2;

import java.util.ArrayList;

public class Node {
	public Node parent;
	public ArrayList<Node> child = new ArrayList<Node>();
	public String content;
	
	public static Node getNodes(ArrayList<StringBuilder> contentSup) {
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
		
		return root;
	}
}
