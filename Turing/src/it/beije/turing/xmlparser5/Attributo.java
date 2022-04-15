package it.beije.turing.xmlparser5;

public class Attributo {
	private String nome;
	private String value;
	
	public Attributo(String nome, String value) {
		this.nome = nome;
		this.value = value;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome + "=\"" + value + "\"");
		return sb.toString();
	}

}
