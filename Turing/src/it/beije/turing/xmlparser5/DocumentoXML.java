package it.beije.turing.xmlparser5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DocumentoXML {
	
	private String stringaFile;
	
	public String getStringaFile() {
		return stringaFile;
	}

	public void setStringaFile(String stringaFile) {
		this.stringaFile = stringaFile;
	}
	

//	DENTRO TAG
//	getChildNodes() //torna tutti i nodi "figli" interni all'elemento su cui viene eseguito 
	
//  GETCHILDER()
//	getChildElements() //torna i soli elementi figli dell'elemento su cui viene eseguito
	
//	DENTRO TAG
//	getElementsByTagName(String tagName) //torna TUTTI gli elementi con quello specifico nome 
	
//	CORRISPONDE AL GETNOME DI TAG
//	getTagName() //torna il nome del tag 

//	CORRISPONDE AL GETCONTENUTO DI TAG
//	getTextContent() //torna il contenuto del tag 
	
//	CORRISPONDE AL GTATTRIBUTI DI TAG
//	getAttributes() //torna l'elenco degli attributi dell'elemento 
	
//	CORRISPONDE AL getAttribute DI TAG
//	getAttribute(String attribute) //torna il valore dell'attributo specificato 

	
	
	public List<String> getAttributeFromString(String text) {
		List<String> attrs = new ArrayList<>();
		if (text.length() > 0) {
			String tagName = getTagNameFromString(text);
			int firstSpacebar = text.indexOf(" ");
			if (tagName == null) return null;
			if (firstSpacebar == -1) return null;
			int indexOfTagName = text.indexOf(tagName);
			int closingTag = text.indexOf(">", indexOfTagName);
			if (firstSpacebar > closingTag) return null;
			else {
				int startAttr = firstSpacebar + 1;
				
				while ((firstSpacebar != -1) && (firstSpacebar < closingTag)) {
					String attr = new String();
					int startAttrValue = text.indexOf("=", firstSpacebar) + 2;
					int endAttr = text.indexOf("\"", startAttrValue) + 1;
					
					attr = text.substring(startAttr, endAttr);
//					System.out.println("ATTRIBUTO:"+attr);
					attrs.add(attr);
					
					firstSpacebar = text.indexOf(" ", endAttr);
					startAttr = firstSpacebar + 1;
				}
				
				return attrs;
			}
		}
		
		return null;
		
	}
	
	public String getAttributeValueFromString(String attr) {
		String value = null;
		int beginValue = attr.indexOf("=") + 2;
		if (beginValue > 0) {
			int endValue = attr.length() - 1;
			value = attr.substring(beginValue, endValue);
		}
		
		return value;
	}
	
	public String getAttributeNameFromString(String attr) {
		String name = null;
		int endName = attr.indexOf("=");
		if (endName != -1)
			name = attr.substring(0, endName);
		
		return name;
	}

	public String getTextContentString(String el){
		int indexBegin = el.indexOf("<", el.indexOf(">"));
		int indexEnd = el.lastIndexOf("<");
		if (indexBegin == indexEnd) {
			indexBegin = el.indexOf(">") + 1;
		}
		String textContent = el.substring(indexBegin, indexEnd);
		return textContent;
	}
	
	public List<String> getChildElements(String textContent) {
        List<String> children = new ArrayList<>();
        String tagName = getTagNameFromString(textContent);


        while ((tagName != null) && textContent.contains(tagName)) {
            String closureTag = "/" + tagName + ">";
            int indexBegin = textContent.indexOf("<");
            int startClosure = textContent.indexOf(closureTag);
            int endClosure = startClosure + closureTag.length();

            String child = textContent.substring(indexBegin, endClosure);

            int cutContentFrom = textContent.indexOf("<", startClosure);
            if (cutContentFrom != -1) {
                textContent = textContent.substring(cutContentFrom);
                tagName = getTagNameFromString(textContent);
            } else {
                textContent = "";
            }

            children.add(child);
        }


        return children;
    }
	
	public List<TagNamePosition> getListaNomeTag(String tag , String textContent){
		List<TagNamePosition> l = new ArrayList<TagNamePosition>();
		int verifica = 0;
		int indice = -(tag.length());
		while(indice != -1) {
			indice = textContent.indexOf(tag , indice);
			if(indice != -1) {
				l.add(new TagNamePosition(tag, indice));
				indice = indice + tag.length();
			}
		}
		return l;
	}
	
	public List<String> getSubStringAperturaChiusura(String textContent){
		List<String> listaSub = new ArrayList<String>();
		List<TagNamePosition> l4 = getListaNomeTag("<contatto" , textContent);
		List<TagNamePosition> l5 = getListaNomeTag("</contatto" , textContent);
		if(l4.size() != l5.size()) {
			System.out.println("vedi entro nel null");
			return null;
		}
		
		for (int i = 0; i < l4.size(); i++) {
			int indiceApertura = l4.get(i).getPosizione();
			int indiceChiusura = l5.get(i).getPosizione();
			int conta = 0;
			for (TagNamePosition t : l4) {
				if(t.getPosizione() > indiceApertura && t.getPosizione() < indiceChiusura) {
					conta++;
				}
				if(conta != 0) { // && (l4.size() + conta) <= l4.size() verifica eccessiva 
					TagNamePosition t1 = l5.get(i+conta);
					System.out.println("conta " + conta);
					System.out.println("conta + i " + (i + conta));
					String s = textContent.substring(indiceApertura, t1.getPosizione()-1);
					listaSub.add(s);
				}
			}
			
		}
		return listaSub;
	}
	
	public int getIndexOfChild(String el , String c) { 
		int index = el.indexOf(c , el.indexOf(">"));
		return index;
	}
	
	public String getTagNameFromString(String el) {
		String tagName = new String();
		if (el.length() > 0) {
			
			int firstSpacebar = el.indexOf(" ");
			int startIndex = el.indexOf("<") + 1;
			int closingTag = el.indexOf(">");
			if (closingTag == -1 ) {
				return null;
			}
			if (firstSpacebar == -1) {
				tagName = el.substring(startIndex, closingTag);
			} else if(firstSpacebar > closingTag){
				tagName = el.substring(startIndex, closingTag);
			} else {
				tagName = el.substring(startIndex, firstSpacebar);
			}
			return tagName;
		}
		
		return null;
		
	}
	
	
	public Tag getRootElement() {
		String rootStringa = removeDeclarationTag();
		String nome = getTagNameFromString(rootStringa).trim(); // ritorna "contatti"
		String textContent = getTextContentString(rootStringa); // ritorna tutto il contenuto del tag contatti
		
		Tag root = new Tag(nome, textContent);
		
		List<String> childrenStringa = getChildElements(textContent);
		
		for (String child : childrenStringa) {
			List<String> attributeString = getAttributeFromString(child);
			String tagName = getTagNameFromString(child);
			String tagContent = getTextContentString(child);
			Tag tagFiglio = new Tag(tagName, tagContent);
			
			if (attributeString != null) {
				for (String attr : attributeString) {
					String nomeAttr = getAttributeNameFromString(attr);
					String valueAttr = getAttributeValueFromString(attr);
					Attributo attributo = new Attributo(nomeAttr, valueAttr);
					tagFiglio.addAttributo(attributo);
				}
			}
			
			root.addTag(tagFiglio);
		}
		return root;
	}
	
	public Tag getTreeDocument(Tag tag) {
		List<Tag> children = tag.getChildren();
		
		for (Tag child : children) {
			List<String> childrenString = getChildElements(child.getContenuto());
			
			for (String childString : childrenString) {
				List<String> attributeString = getAttributeFromString(childString);
				String tagName = getTagNameFromString(childString);
				String tagContent = getTextContentString(childString);
				Tag tagFiglio = new Tag(tagName, tagContent);
				
				if (attributeString != null) {
					for (String attr : attributeString) {
						String nomeAttr = getAttributeNameFromString(attr);
						String valueAttr = getAttributeValueFromString(attr);
						Attributo attributo = new Attributo(nomeAttr, valueAttr);
						tagFiglio.addAttributo(attributo);
					}
				}
				
				child.addTag(tagFiglio);
			}
			
			getTreeDocument(child);
		}
		return tag;
	}

	public String getContenutoFile(String path) {
		StringBuilder s = new StringBuilder();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			while (br.ready()) {
				s.append((char) br.read());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return s.toString();
	}

	public String removeDeclarationTag() {
		String s = this.stringaFile;
		String senzaIntestazione = null;
		if(s.startsWith("<?") && s.contains("?>")) {
			senzaIntestazione = s.substring(s.indexOf("?>") + 2);
		}
		if(senzaIntestazione != null) {
			return senzaIntestazione;
		}
		return s;
		
	}

}
