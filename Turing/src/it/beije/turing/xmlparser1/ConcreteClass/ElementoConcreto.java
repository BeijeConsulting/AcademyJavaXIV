package it.beije.turing.xmlparser1.ConcreteClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.beije.turing.xmlparser1.Interfaces.Elemento;

public class ElementoConcreto extends NodoConcreto implements Elemento {
	private String tagName;
	private String textContent;
	private HashMap<String,Attributo> attributes;
	
	

	public ElementoConcreto(String testoCompleto) {
		super(testoCompleto);
		tagName = "";
		textContent = "";
		attributes = new HashMap<String,Attributo>();
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}
	
	public HashMap<String, Attributo> getAttributes() {
		return attributes;
	}

	public void setAttributes(HashMap<String, Attributo> attributes) {
		this.attributes = attributes;
	}
	
	@Override
	public List<Elemento> getElementsByTagName(String tagName, List<Elemento> r, int j){
		String tagNameWithAttributes = null;
		ArrayList<Elemento> ris = new ArrayList<>(r);
		ArrayList<Attributo> attList = new ArrayList<>();
		String[] tmp = textContent.split("\n");
		for(int i = j; i < tmp.length; i++) {
			if(tmp[i].contains("=") && tmp[i].contains("<") && tmp[i].contains(">") && tmp[i].trim().contains(" ") && tmp[i].trim().substring(1,tmp[i].indexOf(" ")-1).equals(tagName)) {
				String a = tmp[i].trim().substring(tmp[i].indexOf(" "));
				a = a.substring(0,a.indexOf(">"));
				String bin = tmp[i];
				bin = bin.trim();
				bin = bin.substring(1,bin.length()-1);
				for(int k = 0; k < bin.length(); k++) {
					if(bin.charAt(k) == ' ') {
						bin = bin.substring(k+1);
						String key = bin.substring(0,bin.indexOf("="));
						String value;
						if(bin.indexOf("\" ") == -1) {
							value = bin.substring(bin.indexOf("=")+1);
							k = bin.length();
						}else {
							value = bin.substring(bin.indexOf("=")+1,bin.indexOf("\" "));
							k = bin.indexOf("\" ");
						}
						Attributo attributoTmp = new Attributo(key,value);
						System.out.println("key: "+key+" value: "+value);
						attList.add(attributoTmp);
					}
				}
/*
				for(Attributo attributoTmp: attList) {
					attributes.putIfAbsent(attributoTmp.getNome(), attributoTmp);
				}
*/
				tagNameWithAttributes = tmp[i].trim().substring(1,tmp[i].indexOf(" ")-1);
				
				if(tagNameWithAttributes.equals(tagName)) {
					if(tmp[i].contains("/>")){
						Elemento tmpElemento = new ElementoConcreto(tmp[i]);
						tmpElemento.setTagName(tagName);
						tmpElemento.setTextContent(tmp[i].substring(tmp[i].indexOf(">")+1,tmp[i].lastIndexOf("<")));
						ris.add(tmpElemento);
						return ris;
					}
					for(int k = i + 1; k < tmp.length; k++) {
						if(tmp[k].indexOf("<") == -1 || tmp[k].indexOf(">") == -1) continue;
						if(tmp[k].substring(tmp[k].indexOf("<")+1,tmp[k].indexOf(">")).equals(tagName)) {
							ris = (ArrayList<Elemento>) getElementsByTagName(tagName, ris, k);
							continue;
						}
						if(tmp[k].substring(tmp[k].indexOf("<")+1,tmp[k].indexOf(">")).equals("/"+tagName)) {
							String allTextChild = "";
							for(int t = i; t <= k; t++) {
								allTextChild += tmp[t];
								allTextChild += "\n";
							}
							Elemento e = new ElementoConcreto(allTextChild);
							e.setTagName(tagName);
							for(int t = i+1; t < k; t++) {
								e.setTextContent(e.getTextContent()+tmp[t]);
								e.setTextContent(e.getTextContent()+"\n");
							}
							HashMap<String,Attributo> hm = new HashMap<>();
							for(Attributo m : attList) {
								hm.put(m.getNome(), m);
							}
							e.setAttributes(hm);
							ris.add(e);
							i = k;
							break;
						}
					}
				}
				
			}else {
				if(tmp[i].indexOf("<") == -1 || tmp[i].indexOf(">") == -1) continue;
				if(tmp[i].substring(tmp[i].indexOf("<")+1,tmp[i].indexOf(">")).equals(tagName)) {
					if(tmp[i].contains("/")){
						Elemento tmpElemento = new ElementoConcreto(tmp[i]);
						tmpElemento.setTagName(tagName);
						tmpElemento.setTextContent(tmp[i].substring(tmp[i].indexOf(">")+1,tmp[i].lastIndexOf("<")));
						ris.add(tmpElemento);
						return ris;
					}
					for(int k = i + 1; k < tmp.length; k++) {
						if(tmp[k].indexOf("<") == -1 || tmp[k].indexOf(">") == -1) continue;
						if(tmp[k].substring(tmp[k].indexOf("<")+1,tmp[k].indexOf(">")).equals(tagName)) {
							ris = (ArrayList<Elemento>) getElementsByTagName(tagName, ris, k);
							continue;
						}if(tmp[k].substring(tmp[k].indexOf("<")+1,tmp[k].indexOf(">")).equals("/"+tagName)) {
							String allTextChild = "";
							for(int t = i; t <= k; t++) {
								allTextChild += tmp[t];
								allTextChild += "\n";
							}
							Elemento e = new ElementoConcreto(allTextChild);
							e.setTagName(tagName);
							for(int t = i+1; t < k; t++) {
								e.setTextContent(e.getTextContent()+tmp[t]);
								e.setTextContent(e.getTextContent()+"\n");
							}
							ris.add(e);
							i = k;
							break;
						}
					}
				
				}
			}
		}
		return ris;
	}

	@Override
	public String getAttribute(String attribute) {
		if(getAttributes().get(attribute) != null) {
			return getAttributes().get(attribute).getValue();
		}
		return null;
	}

	@Override
	public void setAttributes(Map<String, Attributo> attributes) {
		this.attributes = (HashMap<String, Attributo>) attributes;
	}
}
