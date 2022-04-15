package it.beije.turing.xmlparser5;

public class TagNamePosition {
	
	private String nome;
	private int posizione;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPosizione() {
		return posizione;
	}
	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}
	
	public TagNamePosition(String nome, int posizione) {
		super();
		this.nome = nome;
		this.posizione = posizione;
	}
	
	

}
