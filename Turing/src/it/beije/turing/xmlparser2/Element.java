package it.beije.turing.xmlparser2;


import java.util.ArrayList;

public class Element {
	//commento

	private String tag;
	private ArrayList<Element> childElements;
	private String content;
	private String[] attributes;
	
	public Element() {
	}

	public ArrayList<Element> getChildElements() {
		return childElements;
	}

	public void setChildElements(ArrayList<Element> childElements) {
		this.childElements = childElements;
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
