package it.beije.turing.xmlparser2;


import java.util.ArrayList;

public class Element extends Node {
	//commento

	private String content;
	private ArrayList<Element> childElements = new ArrayList<>();
	
	private ArrayList<Attribute> attributes = new ArrayList<>();
	
	public Element(Node node) {
		this.parent = node.parent;
		
		if(node.child.size() != 0)
			this.child = (ArrayList<Node>) node.child.clone();
		
		this.tag = node.tag;
	}
	
	

	public ArrayList<Element> getChildElements() {
		return childElements;
	}

	public void setChildElements(ArrayList<Element> childElements) {
		for(Element e : childElements) {
			setChildElements(e);
		}
	}
	public void setChildElements(Element childElement) {
		this.childElements.add(childElement);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	

	public String getAttributes() {
		return tag;
	}

	public void setAttributes(String tag) {
		this.tag = tag;
	}

	public ArrayList<Element> getElementsByTagName(String tagName) {
		ArrayList<Element> elements = new ArrayList<>();
		for(Element e : childElements) {
			if(e.getTag().equals(tagName))
				elements.add(e);
		}
		return elements;
	}
}
