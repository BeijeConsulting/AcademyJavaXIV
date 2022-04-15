package it.beije.turing.xmlparser2;

import java.util.ArrayList;

public class Node {
	public Node parent;
	public ArrayList<Node> child = new ArrayList<Node>();
	public String tag;
	//Debug
	public Node() {}
	public Node(Node n) {
		this.parent = n.parent;
		if(!n.child.isEmpty())
			this.child = (ArrayList)n.child.clone();
		this.tag = n.tag;
	}
	
	
	
	public static Node getNodes(ArrayList<StringBuilder> contentSup) {
		ArrayList<Node> parentList = new ArrayList<Node>();
		ArrayList<Node> nodes = new ArrayList<Node>();
		Node root = new Node();
		root.tag = contentSup.get(0).toString();
		parentList.add(root);
		for(int i = 1; i < contentSup.size(); i++) {
			Node node = new Node();
			node.tag = contentSup.get(i).toString();
			if(!node.tag.equals(parentList.get(parentList.size() - 1).tag) && !node.tag.toString().contains("t-") && !node.tag.toString().contains("**")) {
				node.parent = parentList.get(parentList.size() - 1);
				parentList.get(parentList.size() - 1).child.add(node);
				parentList.add(node);
				//nodes.add(node);
			} else if(node.tag.toString().contains("t-") || node.tag.toString().contains("**")) {
				node.parent = parentList.get(parentList.size() - 1);
				parentList.get(parentList.size() - 1).child.add(node);
				nodes.add(node);
			} else if(node.tag.equals(parentList.get(parentList.size() - 1).tag)) {
				nodes.add(parentList.get(parentList.size() - 1));
				parentList.remove(parentList.size() - 1);
			}
			
			//root.child.add(node);
		}
		
		return root;
	}
}
