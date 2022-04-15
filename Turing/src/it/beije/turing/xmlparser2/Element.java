package it.beije.turing.xmlparser2;


import java.util.ArrayList;

public class Element extends Node {
	//commento

	private String content = "";
	private ArrayList<Element> childElements = new ArrayList<>();
	private ArrayList<Attribute> attributes = new ArrayList<>();
	
	public Element(Node node) {
		this.parent = node.parent;
		
		if(node.child.size() != 0)
			this.child = (ArrayList<Node>) node.child.clone();
		
		String strTag = "";
		for(int i = 0; i < node.tag.length(); i++) {
			if(node.tag.charAt(i) == ' ') {
				break;
			}
			strTag += node.tag.charAt(i);
		}
		this.tag = strTag;
	}
	
	public ArrayList<Element> getChildElements() {
		if(childElements.size() == 0) {
			ArrayList<Element> childElements = new ArrayList<Element>();
			for(Node n : super.child) {
				if(!n.tag.substring(0, 2).equals("t-")) {
					Element newElm = new Element(n);
					newElm.setAttributes(n);
					childElements.add(newElm);
				} else {
					this.content += n.tag.substring(2, n.tag.length());
				}
			}
			this.childElements = childElements;
			return this.childElements;
		} else {	
			return this.childElements;
		}
	}

	public void setChildElements(ArrayList<Element> childElements) {
		for(Element e : childElements) {
			setChildElements(e);
		}
	}
	public void setChildElements(Element childElement) {
		this.childElements.add(childElement);
	}

	public String getTextContent() {
		if(childElements.size() == 0) {
			this.childElements = getChildElements();
		} 
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTagName() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	

	public ArrayList<Attribute> getAttributes() {
		return this.attributes;
	}
	
	

	public void setAttributes(Node node) {
		String attributesString = "";
		String tagName = node.tag;
		String[] attributesArray = null;
		
		for(int i = 0, y = 0; i < tagName.length(); i++) {
			if(i > 0 && tagName.charAt(i-1) == ' ') {
				y++;
			}
			if(y == 1) {
				attributesString += tagName.charAt(i);
			}
		}
		if(attributesString.length() > 0) {
			attributesString = attributesString.substring(1,attributesString.length());
			attributesString = attributesString.substring(0, attributesString.length() - 1);
			
			if(attributesString.contains(" ")) {
				attributesArray = attributesString.split(" ");
			} else {
				attributesArray = new String[1];
				attributesArray[0] = attributesString;
			}
			
			this.attributes = Attribute.buildAttributes(attributesArray);
		}
	}

	public ArrayList<Element> getElementsByTagName(String tagName) {
		ArrayList<Element> elements = new ArrayList<>();
		
		if(this.childElements.size() == 0) {
			this.childElements = getChildElements();
		}
		for(Element e : this.childElements) {
			if(e.getTagName().equals(tagName))
				elements.add(e);
		}
		return elements;
	}
	
	public ArrayList<Node> getChildNodes() {		
		return this.child;
	}
}
