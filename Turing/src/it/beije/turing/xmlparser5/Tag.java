package it.beije.turing.xmlparser5;

import java.util.ArrayList;
import java.util.List;


public class Tag extends Nodo{

	private String nome;
	private List<Attributo> attributi = new ArrayList<Attributo>();
	private String contenuto;
	private List<Tag> children = new ArrayList<Tag>();

	public Tag(String nome) {
		this.nome = nome;
	}

	public Tag(String nome, String contenuto) {
		this.nome = nome;
		this.contenuto = contenuto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Attributo> getAttributi() {
		return attributi;
	}

	public void addAttributo(Attributo a) {
		this.attributi.add(a);
	}

	public void setAttributi(List<Attributo> attributi) {
		this.attributi = attributi;
	}

	public String getContenuto() {
		return contenuto;
	}

	public void setContenuto(String contenuto) {
		this.contenuto = contenuto;
	}

	public List<Tag> getChildren() {
		return children;
	}

	public void addTag(Tag tag) {
		this.children.add(tag);
	}

	public void setChildren(List<Tag> children) {
		this.children = children;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome " + this.nome + "\n");
		sb.append("Contenuto " + this.contenuto + "\n");
		for (Attributo attributo : attributi) {
			sb.append("Attributo " + "\n" + attributo.toString() + "\n");
		}

		for (Tag tag : children) {
			sb.append("Child " + "\n" + tag.toString() + "\n");
		}
		return sb.toString();
	}
	
	public String getAttribute(String attrName) {
		String value = null;	
		for (Attributo attr : attributi) {
			if (attr.getNome().equals(attrName)) {
				value = attr.getValue();
				break;
			}
		}
		
		return value;
	}

	public List<Tag> getElementsByTagName(String tagName) {
		List<Tag> l1 = new ArrayList<Tag>();
		for (Tag tag : children) {
			if(tag.getNome().equalsIgnoreCase(tagName)) {
				l1.add(tag);
			}
			List<Tag> l2 = tag.getElementsByTagName(tagName);
			if(l2.size() != 0) {
				l1.addAll(l2);
			}
		}
		return l1;
	}

	public List<Nodo> getChildNodes(){
		List<Nodo> l = new ArrayList<Nodo>();
		l.addAll(this.children);
		for(int i = 0 ; i < children.size() + 1 ; i++) {
			Nodo nodo = new Nodo();
			l.add(nodo);
		}
		return l;
	}

}
