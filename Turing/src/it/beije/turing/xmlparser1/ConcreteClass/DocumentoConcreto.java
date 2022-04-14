package it.beije.turing.xmlparser1.ConcreteClass;

import java.util.List;
import java.util.ArrayList;

import it.beije.turing.xmlparser1.Interfaces.Documento;
import it.beije.turing.xmlparser1.Interfaces.Elemento;

public class DocumentoConcreto implements Documento {
	private List<String> testoTotale;
	private String path;

	public DocumentoConcreto() {
		super();
		testoTotale = new ArrayList<>();
		path = "";
	}
	
	public List<String> getTestoTotale() {
		return testoTotale;
	}
	
	public void setTestoTotale(List<String> testoTotale) {
		this.testoTotale = testoTotale;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	private String ToStringTestoTotale() {
		String tmp = "";
		for(int i = 1; i < testoTotale.size(); i++) {
			tmp += (testoTotale.get(i) + "\n");
		}
		return tmp;
	}
	
	public Elemento getDocumentElement(){
		String s = ToStringTestoTotale();
		ElementoConcreto e = new ElementoConcreto(s);
		if(testoTotale.size() >= 2) {
			if(testoTotale.size() == 2) {
				
			}
			String tmp = testoTotale.get(1);
			String tmp2 = testoTotale.get(testoTotale.size()-1);
			try {
				if(tmp == null) {
					throw new Exception("Formato riga 1 errato, null");
				} else if(tmp2 == null) {
					throw new Exception("Formato ultima riga errato, null");
				}
				if(tmp.charAt(0) != '<' || tmp.charAt(tmp.length()-1) != '>') {
					throw new Exception("Formato riga 1 errato");
				} else if(tmp2.charAt(0) != '<' || tmp2.charAt(tmp2.length()-1) != '>') {
					throw new Exception("Formato ultima riga errato");
				}
				if(tmp.indexOf(" ") == -1) {
					if(!("/"+tmp.substring(1)).equals(tmp2.substring(1))) {
						throw new Exception("TagName root non combacia");
					}
					e.setTagName(tmp.trim().substring(1,tmp.length()-1));
				}else {
					String a = tmp.trim();
					if(!a.contains("=")) {
						throw new Exception("formato attributo errato");
					}
					ArrayList<Attributo> att = new ArrayList<>();
					String bin = tmp;
					bin = bin.trim();
					bin = bin.substring(0,bin.length()-1);
					for(int i = 0; i < bin.length(); i++) {
						if(bin.charAt(i) == ' ') {
							bin = bin.substring(i+1);
							if(bin.indexOf("=") == -1) {
								if(bin.contains("http")) {
									
								}
								//throw new Exception("Formato errato, aspettato un =");
							}System.out.println("bin " +bin);
							String key = bin.substring(0,bin.indexOf("="));
							String value;
							if(bin.indexOf("\" ") == -1) {
								value = bin.substring(bin.indexOf("=")+1);
								i = bin.length();
							}else {
								value = bin.substring(bin.indexOf("=")+1,bin.indexOf("\" "));
								i = bin.indexOf("\" ");
							}
							Attributo attributoTmp = new Attributo(key,value);
							att.add(attributoTmp);
						}
					}
					a = a.substring(1,a.indexOf(" "));
					
					if(!("/"+a).equals(tmp2.trim().substring(1,tmp2.length()-1))) {
						throw new Exception("TagName root non combacia");
					}
					for(Attributo attributoTmp: att) {
						e.getAttributes().putIfAbsent(attributoTmp.getNome(), attributoTmp);
					}
					e.setTagName(a);
				}
				for(int i = 2; i < testoTotale.size()-1; i++) {
					e.setTextContent(e.getTextContent().concat(testoTotale.get(i)+"\n"));
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
		return e;
	}
	
}
