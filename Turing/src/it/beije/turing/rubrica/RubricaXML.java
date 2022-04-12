package it.beije.turing.rubrica;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.w3c.dom.Element;
import it.beije.turing.file.XMLmanager;

public class RubricaXML {
	private List<Element> allContact;
	private Path path;
	
	
	
	public RubricaXML(Path path) {
		super();
		this.allContact = XMLmanager.readXML(path.toAbsolutePath().toString());
		this.path = path;
	}
	
	public List<Element> getAllContact() {
		return allContact;
	}
	public void setAllContact(List<Element> allContact) {
		this.allContact = allContact;
	}
	public Path getPath() {
		return path;
	}
	public void setPath(Path path) {
		this.path = path;
	}
	
	public void vediListaContatti() {
		for(Element e : allContact) {
			System.out.println(e.getTagName()+": "+ e.getTextContent());
		}
	}
	
	public void trovaDuplicatiModifica() {
		// TODO Auto-generated method stub
		
	}

	public void cancellaContatto() {
		// TODO Auto-generated method stub
		
	}

	public void inserisciNuovoContatto() {
		// TODO Auto-generated method stub
		
	}

	public void trovaDuplicati() {
		// TODO Auto-generated method stub
		
	}

	public void modificaContatto() {
		// TODO Auto-generated method stub
		
	}

	public void cercaContatto() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		RubricaXML r = new RubricaXML(Paths.get("File","rubrica.xml"));
		r.vediListaContatti();
		r.cercaContatto();
		r.inserisciNuovoContatto();
		r.modificaContatto();
		r.cancellaContatto();
		r.trovaDuplicati();
		r.trovaDuplicatiModifica();
	}

	
}
