package it.beije.turing.xmlparser2;

public class Element {
	private String tag;
	private String[] childElements;
	private String content;
	private String[] attributes;
	
	public Element() {
		
	}

	public String[] getChildElements() {
		return childElements;
	}

	public void setChildElements(String[] childElements) {
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

}
