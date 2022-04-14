package it.beije.turing.xmlparser6;

import java.util.List;

public class Elemento
{
	private String tagName;
	private List<Attributi> attributes;
	private String textContent;
	private List<Elemento> childElements;
	private List<Elemento> childNodes;
	private Elemento father;
	
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	
	public List<Attributi> getAttributes() {
		return attributes;
	}
	
	public void setAttributes(List<Attributi> attributes) {
		this.attributes = attributes;
	}
	
	
	public String getTextContent() {
		return textContent;
	}
	
	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}
	
	
	public List<Elemento> getChildElements() {
		return childElements;
	}
	
	public void setChildElements(List<Elemento> childElements) {
		this.childElements = childElements;
	}
	
	
	public List<Elemento> getChildNodes() {
		return childNodes;
	}
	
	public void setChildNodes(List<Elemento> childNodes) {
		this.childNodes = childNodes;
	}
	
	
	public Elemento getFather()
	{
		return father;
	}
	
	public void setFather(Elemento father)
	{
		this.father = father;
	}
}