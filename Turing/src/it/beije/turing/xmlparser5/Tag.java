package it.beije.turing.xmlparser5;

import java.util.ArrayList;
import java.util.List;

public class Tag {
	
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
		
		for (Tag tag: children) {
			sb.append("Child " + "\n" + tag.toString()  + "\n");
		}
		return sb.toString();
	}
	
	
	public List<Tag> getElementsByTagName(String tagName){
		List<Tag> tagsByName = new ArrayList<Tag>();
		if(this.getNome().equalsIgnoreCase(tagName)) {
			tagsByName.add(this);
		}
		for (Tag tag : getChildren()) {
			if(tag.getNome().equalsIgnoreCase(tagName)) {
				tagsByName.add(tag);
			}
		}
		return tagsByName;
	}
	
	
	
}
