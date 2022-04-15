package it.beije.turing.xmlparser1.ConcreteClass;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public String toString() {
		return "Attributo [nome=" + nome + ", value=" + value + "]";
	}
}
