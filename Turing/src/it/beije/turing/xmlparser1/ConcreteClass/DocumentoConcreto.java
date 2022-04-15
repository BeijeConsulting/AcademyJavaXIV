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
		ElementoConcreto e = null;
		if(testoTotale.size() >= 2) {
			if(testoTotale.size() == 2) {
				List<String> testoTotaleUnaRiga = new ArrayList<>();
				testoTotaleUnaRiga.add(testoTotale.get(0));
				String tmp = "";
				for(int i = 0; i < testoTotale.get(1).length(); i++) {
					if(testoTotale.get(1).charAt(i) == '<') {
						for(int k = i+1; k < testoTotale.get(1).length(); k++) {
							if(testoTotale.get(1).charAt(k) == '>') {
								
								testoTotaleUnaRiga.add(tmp+testoTotale.get(1).substring(i,k+1));
								tmp = "";
								i = k;
								break;
							}
						}
					}else {
						tmp += testoTotale.get(1).charAt(i);
						//System.out.println(tmp);
					}
				}
				testoTotale = testoTotaleUnaRiga;
			}
			List<String> text = new ArrayList<>();
			for(int i = 0; i < testoTotale.size(); i++) {
				if(testoTotale.get(i).contains("<!--")) {
					for(int k = i+1; k < testoTotale.size(); k++) {
						if(testoTotale.get(k).contains("-->")) {
							i = k;
							break;
						}
					}
				}else {
					text.add(testoTotale.get(i));
				}
			}
			setTestoTotale(text);
			String s = ToStringTestoTotale();
			try {
				if(checkFileFormat()) {
					throw new Exception("Formato file non corretto!");
				}
			}catch(Exception ex) {
				ex.printStackTrace();
				return null;
			}
			
			e = new ElementoConcreto(s);
			String tmp = testoTotale.get(1);
			String tmp2 = testoTotale.get(testoTotale.size()-1);
			tmp = tmp.trim();
			tmp2 = tmp2.trim();
			try {
				if(tmp == null) {
					throw new Exception("Formato riga 1 errato, null");
				} else if(tmp2 == null) {
					throw new Exception("Formato ultima riga errato, null");
				}
				if(tmp.charAt(0) != '<' || tmp.charAt(tmp.length()-1) != '>') {
					throw new Exception("Formato riga 1 errato");
				} else if(tmp2.charAt(0) != '<' || tmp2.charAt(tmp2.length()-1) != '>') {
					//System.out.println("tmp2: "+tmp2);
					throw new Exception("Formato ultima riga errato");
				}
				if(tmp.indexOf(" ") == -1) {
					//System.out.println(tmp.substring(1)+" "+ tmp2.substring(1));
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
							
							String key = bin.substring(0,bin.indexOf("="));
							String value;
							if(bin.indexOf("\" ") == -1) {
								value = bin.substring(bin.indexOf("=")+1);
								i = bin.length();
							}else {
								value = bin.substring(bin.indexOf("=")+1,bin.indexOf("\" ")+1);
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
						e.getAttributes(true).putIfAbsent(attributoTmp.getNome(), attributoTmp);
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
	
	//ritorna true se il file format è errato
	private boolean checkFileFormat() {
		List<String> openClose = new ArrayList<>();
		/*String q = testoTotale.get(1).trim();
		q = q.substring(1,q.length()-1);
		openClose.add(q);*/
		for(int i = 1; i < testoTotale.size(); i++) {
			if((testoTotale.get(i).contains("</") || testoTotale.get(i).contains("/>")) && testoTotale.get(i).contains("<") && testoTotale.get(i).contains(">")) {
				String s = null;
				if(testoTotale.get(i).contains("/>")) {
					if(testoTotale.get(i).contains(" ")) {
						if(checkFormatoAttributi(testoTotale.get(i))) {
							System.out.println("Formato attributi non corretto! Errore sulla linea " + (i+1));
							return true;
						}
					}
					continue;
				}else if(testoTotale.get(i).contains("</")) {
					String check = testoTotale.get(i).trim();
					s = testoTotale.get(i).trim();
					s = s.substring(s.indexOf("/")+1,s.lastIndexOf(">"));
					if(check.indexOf("<") != check.indexOf("</")) {
						openClose.add(s);
					}
				}else {
					s = testoTotale.get(i).trim();
					s = s.substring(1,s.length()-1);
				}
				
				if(openClose.size() != 0 && !openClose.get(openClose.size()-1).equals(s)) {
					//System.out.println(openClose.get(openClose.size()-1)+" "+s);
					System.out.println("Formato file non corretto! Errore sulla linea " + (i+1));
					return true;
				}
				if(openClose.size() == 0) {
					continue;
				}else {
					openClose.remove(openClose.size()-1);
				}
			}else if(testoTotale.get(i).contains("<") && testoTotale.get(i).contains(">")) {
				if(testoTotale.get(i).trim().contains(" ") && testoTotale.get(i).contains("=")) {
					if(checkFormatoAttributi(testoTotale.get(i))) {
						System.out.println("Formato attributi non corretto! Errore sulla linea " + (i+1));
						return true;
					}
					String s = testoTotale.get(i).trim();
					s = s.substring(1,s.indexOf(" "));
					//System.out.println("s: "+s);
					openClose.add(s);
				}else if(testoTotale.get(i).contains("/>") || testoTotale.get(i).contains("</")) {
					
				}else {
					String s = testoTotale.get(i).trim();
					s = s.substring(1,s.length()-1);		
					openClose.add(s);				
				}
			} 
		}
		return false;
	}

	
private boolean checkFormatoAttributi(String string) {
		
		String s = string.trim();
		s = s.substring(s.indexOf(" "));
		if(s.contains("/>")) {
			s = s.substring(0,s.length()-2);
		}else {
			s = s.substring(0,s.length()-1);
		}
		List<String> att = new ArrayList<>();
		String t = null;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				
				for(int k = i+1; k < s.length(); k++) {
					
					s = s.substring(k);
					
					if(s.substring(s.indexOf("\"")+1).indexOf(" ") < s.substring(s.indexOf("\"")+1).indexOf("\"") && s.substring(s.indexOf("\"")+1).indexOf(" ") != -1) {
						
						String t2 = s.substring(s.indexOf("\"")+1);
						for(int q = 1; q < t2.length(); q++) {
							if(t2.charAt(q) == '"') {
								t2 = "\"" + t2.substring(0,q+1);
								
								break;
							}
						}
						t = s.substring(0,s.indexOf("\""));
						
						t = t.concat(t2);
						
						s = s.substring(t.length());
						break;
					}else if(s.indexOf(" ") != -1 && !(s.substring(s.indexOf("\"")+1).indexOf(" ") < s.substring(s.indexOf("\"")+1).indexOf("\""))) {
						t = s.substring(0,s.indexOf(" "));
						
						s = s.substring(s.indexOf(" "));
						
						break;
					}else{
						t = s.substring(k);
					
						s = "";
						break;
					}
				}
				att.add(t);
				t = null;
				i = -1;
			}
		}
		if(att.size() == 0) return true;
		for(int i = 0; i < att.size(); i++) {
			if(att.get(i).contains("=") && att.get(i).contains("\"") && (att.get(i).indexOf("\"") != att.get(i).lastIndexOf("\""))) {
				continue;
			}
			return true;
		}
		return false;
	}
	
}
