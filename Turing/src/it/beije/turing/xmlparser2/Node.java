package it.beije.turing.xmlparser2;

import java.util.ArrayList;

public class Node {
	public Node parent;
	public ArrayList<Node> child = new ArrayList<Node>();
	public String content;
}
