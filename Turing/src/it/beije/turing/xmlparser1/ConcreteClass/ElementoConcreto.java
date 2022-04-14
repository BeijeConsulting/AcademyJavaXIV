package it.beije.turing.xmlparser1.ConcreteClass;

import java.util.ArrayList;
import java.util.List;

import it.beije.turing.xmlparser1.Interfaces.Elemento;

public class ElementoConcreto extends NodoConcreto implements Elemento {
	private String tagName;
	private String textContent;
	
	public ElementoConcreto(String testoCompleto) {
		super(testoCompleto);
		tagName = "";
		textContent = "";
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
	
	@Override
	public List<Elemento> getElementsByTagName(String tagName, List<Elemento> r, int j){
		ArrayList<Elemento> ris = new ArrayList<>(r);
		String[] tmp = textContent.split("\n");
		for(int i = j; i < tmp.length; i++) {
			if(tmp[i].substring(tmp[i].indexOf("<")+1,tmp[i].indexOf(">")).equals(tagName)) {
				if(tmp[i].contains("/")){
					Elemento tmpElemento = new ElementoConcreto(tmp[i]);
					tmpElemento.setTagName(tagName);
					tmpElemento.setTextContent(tmp[i].substring(tmp[i].indexOf(">")+1,tmp[i].lastIndexOf("<")));
					ris.add(tmpElemento);
					return ris;
				}
				for(int k = i + 1; k < tmp.length; k++) {
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
		return ris;
	}

	/*
	 * for(int i = 0; i < tmp.length; i++) {
			if(tmp[i].substring(tmp[i].indexOf("<")+1,tmp[i].indexOf(">")).equals(tagName)) {
				
				for(int j = i + 1; j < tmp.length; j++) {
					if(tmp[j].substring(tmp[j].indexOf("<")+1,tmp[j].indexOf(">")).equals(tagName)) {
						String tcr = componiTestoCompletoRicorsivo(tmp, j);
						List<Elemento> r = new ElementoConcreto(tcr).getElementsByTagName(tagName);
						
					}
					if(tmp[j].substring(tmp[j].indexOf("<")+1,tmp[j].indexOf(">")).equals("/"+tagName)) {
						
						String allTextChild = "";
						for(int k = i; k <= j; k++) {
							allTextChild += tmp[k];
							allTextChild += "\n";
						}
						Elemento e = new ElementoConcreto(allTextChild);
						e.setTagName(tagName);
						for(int k = i+1; k < j; k++) {
							e.setTextContent(e.getTextContent()+tmp[k]);
							e.setTextContent(e.getTextContent()+"\n");
						}
						ris.add(e);
						i = j+1;
					}
				}
				
			}
		}
		return ris;
	 * 
	 */

}
