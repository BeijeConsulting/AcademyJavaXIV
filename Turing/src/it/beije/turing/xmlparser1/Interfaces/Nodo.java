package it.beije.turing.xmlparser1.Interfaces;
import java.util.List;
import it.beije.turing.xmlparser1.ConcreteClass.NodoConcreto;


public interface Nodo {
	public List<NodoConcreto> getChildNodes();
	public String getTestoCompleto();
}
