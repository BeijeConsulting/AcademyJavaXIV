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
	
	
	
}
